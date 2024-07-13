#!groovy

import java.text.SimpleDateFormat

def dateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def date = new Date()
def timestamp = dateFormat.format(date).toString()

pipeline {
    environment {
        team = "QA"
        productName = "ganamovil-test"
        branchName = "develop"
        jiraProjectVersion = "1.0"
        jiraServerAddress = "https://acelerabga.atlassian.net"
        sourceCodeURL = "git@gitlab.bg.com.bo:desarrollo/qa/appmovil/ganamovil/v2/${productName}.git"
    }
    tools {
        gradle "gradle"
    }
    agent { node { label 'Windows-builder' } }
    options { buildDiscarder logRotator( daysToKeepStr: '16',numToKeepStr: '10') }
    stages {
        stage('Setup parameters') {
            steps {
                script {
                    properties([
                        parameters([
                            text('name'),
                            text('description'),
                            choice(
                                choices: ['Runner', 'RunnerPersonalizado'],
                                name: 'runner'
                            ),
                            choice(
                                choices: ['smokeTest', 'smokeTestHistoricoQR', 'smokeTestIniciarSesion', 'smokeTestGenerarCódigoQR', 'smokeTestContraseñaInvalida', 'smokeTestTransferenciaTerceros', 'smokeTestTransferenciaBilleteras', 'smokeTestTransferenciaOtrosBancos', 'smokeTestTransferenciasEntreMisCuentas', 'smokeTestTransferenciasNuevoDestinatarioBilletera', 'smokeTestTransferenciasNuevoDestinatarioMismoBanco', 'smokeTestTransferenciasNuevoDestinatarioBancoExterno', 'smokeTestAfiliarServicioTelefonia/Internet/TvCable', 'acceso', 'qrCodrar', 'afiliarServicio', 'transferencias', 'accesoIniciarSesion', 'afiliarServicioBásico', 'transferenciasEntreMisCuentas', 'auto-433', 'auto-453', 'auto-467', 'auto-704', 'auto-707', 'auto-988', 'auto-452', 'auto-664', 'auto-668', 'auto-670', 'auto-671', 'auto-672'],
                                name: 'tagName'
                            ),
                            choice(
                                choices: ['TEST', 'AUTO'],
                                name: 'projectKey'
                            )
                        ])
                    ])
                }
            }
        }
        stage('Cleanup Workspace') {
            steps {
                cleanWs()
            }
        }
        stage('Code Checkout') {
            steps {
                script {
                    checkout([
                        $class: "GitSCM",
                        branches: [[ name: "${branchName}" ]],
                        userRemoteConfigs: [[ credentialsId: "gitlab", url: "${sourceCodeURL}" ]]
                    ])
                }
            }
        }
        stage('Execute tests') {
            steps {
                script {
                    try {
                        //bat("gradle clean test -Dcucumber.options=\"--tags ${params.tagName}\" aggregate")
                        //bat("gradle clean test -PcucumberArgs=\"--tags ${params.tagName}\" aggregate")
                        //bat("gradle clean test aggregate --info")
                        bat("gradle clean test --tests *${params.runner}* -Dtags=\"@${params.tagName}\" aggregate")
                        echo 'Test Ejecutados sin Fallo'
                        currentBuild.result = 'SUCCESS'
                    } catch (ex) {
                        echo 'Test Ejecutados con Fallo'
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }
        stage('Download features from ZephyrJira') {
            steps {
                script {
                    try {
                        downloadFeatureFiles serverAddress: "${jiraServerAddress}",
                            projectKey: "${params.projectKey}",
                            targetPath: "src/test/resources/features"
                    } catch (e) {
                        echo 'Descarga fallida'
                        currentBuild.result = 'SUCCESS'
                    }
                }
            }
        }
        stage('Publish results in ZephyrScale') {
            steps {
                script {
                    publishTestResults serverAddress: "${jiraServerAddress}",
                        projectKey: "${params.projectKey}",
                        format: "Cucumber",
                        filePath: "target/cucumber-reports/*.json",
                        autoCreateTestCases: true,
                        customTestCycle: [
                            name: "${params.name}",
                            description: "${params.description}",
                            jiraProjectVersion: "${jiraProjectVersion}",
                        ]
                }
            }
        }
        stage('Generate evidence') {
            steps {
                script {
                    try {
                        publishHTML([
                            allowMissing: false,
                            alwaysLinkToLastBuild: true,
                            keepAll: true,
                            reportDir: "${WORKSPACE}//target//site//serenity",
                            reportFiles: 'index.html',
                            reportName: 'Evidencias Automatizacion APIs',
                            reportTitles: 'APIs'
                        ])
                        echo 'Reporte Html realizado con exito'
                    } catch (e) {
                        echo 'Generacion fallida'
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }
    }
}