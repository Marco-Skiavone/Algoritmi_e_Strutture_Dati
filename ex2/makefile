CFLAGS = -w
SOURCES = src/*.c
LIBS = ../libs/*/*.c
v1 = build/dictionary.txt
v2 = build/correctme.txt
v3 = 25
#  v# == > to write as follow:   make run v1=file1 v2=file2 v3=[max_height]
TARGET = build/main_ex2
TEST = build/unit_test

compile:
	gcc $(SOURCES) $(LIBS) $(CFLAG) -c
	mv ./*.o ./build

compileTest: 
	gcc src/unit-test/*.c src/skiplist.c $(LIBS) $(CFLAG) -c
	mv ./*.o ./build

$(TEST): compileTest
	gcc build/unit_test.o build/skiplist.o build/compare.o -o $(TEST)

$(TARGET): compile
	gcc build/skiplist.o build/main_ex2.o build/compare.o -o $(TARGET)

run: $(TARGET)
	./$(TARGET) $(v1) $(v2) $(v3)

test: clear $(TEST)
	./$(TEST)

clear:
	rm -f ./build/*.o ./build/main_ex2 ./build/unit_test