node {
       stage("init"){
            echo "hello  world"
            git credentialsId: '3958983f-8c90-40a6-abd3-6ce97e5fcd26', url: 'https://github.com/godbolerr/appx.git'
            
        }
        stage("build"){
            echo "hello  world in build"
            withEnv(["JAVA_HOME=${ tool 'jdk8' }", "PATH+MAVEN=${tool 'maven311'}/bin:${env.JAVA_HOME}/bin"]) {
                     def mvnHome = tool 'maven311'
                     bat "${mvnHome}/bin/mvn --batch-mode -V clean verify" 
                     
           }
        }
        
        stage("report"){
            step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
        }
        
   
}