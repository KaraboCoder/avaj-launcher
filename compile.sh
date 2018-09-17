find . -name "*.java" > sources.txt  
javac -sourcepath src @sources.txt -d ./ 
java kngwato/student/wethinkcode/avaj/Main scenario.txt;
