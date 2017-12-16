echo "Compiling ..."
cd src/
javac **/*.java
javac *.java
java Main $1
cd ..
