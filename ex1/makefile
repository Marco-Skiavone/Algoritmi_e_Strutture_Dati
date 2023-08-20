CFLAGS = -w
SOURCES = src/*.c
LIBS = ../libs/*/*.c
#  v# == > to write as follow:   make run v1=file1 v2=file2 v3=[k] v4=[field]"
v1 = build/data/records.csv
v2 = build/data/sorted.csv
v3 = 10
v4 = 1
TARGET = build/main_ex1 
TEST = build/unit_test

compile:
	gcc $(SOURCES) $(LIBS) $(CFLAG) -c
	mv ./*.o ./build

compileTest: 
	gcc src/unit-test/*.c src/merge-binInsertion-sort.c $(LIBS) $(CFLAG) -c
	mv ./*.o ./build

$(TEST): compileTest
	gcc build/unit_test.o build/merge-binInsertion-sort.o build/compare.o -o $(TEST)

$(TARGET): compile
	gcc build/merge-binInsertion-sort.o build/main_ex1.o build/compare.o -o $(TARGET)

run: $(TARGET)
	./$(TARGET) $(v1) $(v2) $(v3) $(v4)

test: clear $(TEST)
	./$(TEST)

clear:
	rm -f ./build/*.o ./build/main_ex1 ./build/unit_test ./build/data/sorted.csv