pipeline {
    agent any
    tools {
          gradle 'gradle'
          jdk 'JDK11'
    }
    stages{
        stage('Build'){
               steps{
                   script{
                   if(isUnix()){
                       sh "java -version"
                       sh "gradle init"
                   }
                else{
                       sh "java -version"
                       sh "gradle init"
                 }
              }
        }
}
    stage('Execute Tests') {
         steps{
              script{
                   try{
                       if(isUnix()){
                          echo "Executing"
                          sh 'gradle test'
                          }
                          else{
                            echo "Executing"
                            sh 'gradle test'
                          }
              } finally{
                  publishReport()
              }
             }
            }
           }
          }
         }

           def publishReport(){
               publishHTML(target:[
               reportName: 'Serenity Report',
               reportDir: 'target/reporte',
               reportFiles: 'index.html',
               keepAll: true,
               alwaysLinkToLastBuild: false,
               allowMissing:true
               ])
           }
