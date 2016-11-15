node {
         wrap([$class: 'AnsiColorBuildWrapper']) {
            // Just some echoes to show the ANSI color.
            stage "\u001B[31mI'm Red\u001B[0m Now not"
        }
        
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
        
        stage("archive") {
            
        // Make the output directory.
        bat "mkdir -p output"
    
        // Write an useful file, which is needed to be archived.
        writeFile file: "output/usefulfile.txt", text: "This file is useful, need to archive it."
    
        // Write an useless file, which is not needed to be archived.
        writeFile file: "output/uselessfile.md", text: "This file is useless, no need to archive it."
    
        stage "Archive build output"
        
        // Archive the build output artifacts.
        archiveArtifacts artifacts: 'output/*.txt', excludes: 'output/*.md'        
            
        }
    
}