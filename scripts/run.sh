rm -rf *.class
rm -rf build

mkdir build

javac src/*.java -d build
cd build

echo 'Compiled!'
echo '###################################'

java Main
