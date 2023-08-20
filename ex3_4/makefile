SOURCES = src/*.java src/unit_test/*.java
v = ./build/italian_dist_graph.csv

#env:
#	setenv CLASSPATH ~/Desktop/laboratorio-algoritmi-2022-2023/ex3_4/junit-4.13.2.jar:~/Desktop/laboratorio-algoritmi-2022-2023/ex3_4/hamcrest-core-1.3.jar:.

compile:
	javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar $(SOURCES)

main_compile:
	javac src/*.java

test3: compile
	java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore src.unit_test.MyUnitTest3

test4: compile
	java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore src.unit_test.MyUnitTest4

run: main_compile
	java src.Prim $(v)

clear:
	rm -f  ./*.class ./src/*.class  ./src/unit_test/*.class