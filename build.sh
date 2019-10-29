mkdir -p classes
javac src/*.java -d classes
echo "compiled classes"
cd classes
jar -cvfe ../avaj_launcher.jar avaj.Simulation .
echo "avaj_launcher is done."