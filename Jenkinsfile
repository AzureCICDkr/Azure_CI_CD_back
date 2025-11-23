pipeline {
    agent any

    tools {
        
         gradle  'gradle'
         jdk  'jdk11' 
        
    }
        
       
    

    stages {
        
        stage('git checkout'){
            
            steps{
             checkout([$class: 'GitSCM',
                userRemoteConfigs: [[url: 'http://10.0.0.5:3000/test/ch8_4.git']],
                branches: [[name: '*/main']],
                extensions: [[$class: 'CheckoutOption', timeout: 10]]
            ])
            }
        }// git checkout end 
        
        
        stage('build project'){
            
            
            steps{
                
                  sh 'gradle build'
                  sh 'pwd'
                  sh 'ls'
             
                }// steps end 
            
        }// build project end 
        
        
        stage('mock test stage'){
            
            steps{
                
                  sh 'gradle test'
                
            }//steps end 
            
        }//mock test end 
     
     
        stage('checkstyle stage'){
            
            steps{
                
                    sh 'gradle check'
                    
            }//steps end 
            
        }//checkstyle stage end 
       

 
        stage('sonarqube stage'){
            
            steps{
                
                sh 'curl 10.0.0.10:9000'

                   script {
                        
                        def scannerHome = tool 'sonarscanner'
                        
                        withEnv([
                                    "SCANNERHOME=$scannerHome"
                                 ]){


                       
                        withSonarQubeEnv("sonarserver"){
        
                            sh '''$SCANNERHOME/bin/sonar-scanner  \
                                -Dsonar.projectKey=backend \
                                -Dsonar.projectName=backend \
                                -Dsonar.projectVersion=1.0 \
                                -Dsonar.sources=src \
                                -Dsonar.jacoco.reportsPath=build/jacoco/test.exec \
                                -Dsonar.java.checkstyle.reportPaths=build/reports/checkstyle/test.xml \
                                -Dsonar.java.binaries=build/libs/ch8_4-0.0.1-SNAPSHOT-plain.jar'''
    
                            }//withSonarQube end
                        }//withEnv
                   }// script end 
                
                
            }//sonar step end 
            
        }//sonarqube end 
        
        
        
        
        
        
        
   stage('Quality Gate'){
 
    steps{
        
        timeout(time: 1, unit: 'MINUTES'){
    
            waitForQualityGate abortPipeline: true
    
        	}
    	    }

	}// quality gate end 
  
        

       stage('Publish Over SSH') {
           
            steps{       
                sshPublisher(publishers: [sshPublisherDesc(configName: 'ansible',
                                          transfers: [
                                              sshTransfer(cleanRemote: false,
                                                          excludes: '',
                                                          execCommand: '',
                                                          execTimeout: 240000,
                                                          flatten: false,
                                                          makeEmptyDirs: false,
                                                          noDefaultExcludes: false,
                                                          patternSeparator: '[, ]+',
                                                          remoteDirectory: 'projects/backend',
                                                          remoteDirectorySDF: false,
                                                          removePrefix: '',
                                                          sourceFiles: 'app.jar'),
                                              sshTransfer(cleanRemote: false, excludes: '',
                                                          execCommand: '''cd /home/azureuser/projects/backend
                                                                          ansible-playbook backend-ci.yml > result
                                                                          rm -rf Dockerfile app.jar''',
                                                          execTimeout: 240000,
                                                          flatten: false,
                                                          makeEmptyDirs: false,
                                                          noDefaultExcludes: false,
                                                          patternSeparator: '[, ]+',
                                                          remoteDirectory: 'projects/backend',
                                                          remoteDirectorySDF: false,
                                                          removePrefix: '',
                                                          sourceFiles: 'Dockerfile')],
                                                          usePromotionTimestamp: false,
                                                          useWorkspaceInPromotion: false,
                                                          verbose: false)]
                                                              )
        
        
                           build job: 'backend_cd_pipeline'
                        }// steps end 
                
           } //publish over ssh end 
    
    }//stages end 
    
}// pipeline end 

