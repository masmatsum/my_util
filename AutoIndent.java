
/* TODO: I/F idea

./AutoIndent -f {file_name} 
--indent-chars='[{'
--dedent-chars=']}'
--entry-separator-chars=','
--indentation="  " 

--string=" "
_OR_
--file=/path/to/file

*/

class AutoIndent {

    private static int indent;

    public static void main(String[] args) {
        String target;
        // TODO: Read from file
//        target = ""

        displayFormattedCode(target);

//        System.out.println("------------");

//        displayFormattedCode(target);

    }



    static void displayFormattedCode(String target) {
        indent = 0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (c == '[' || c == '{') {
                emit(c);
                indent += 2;
                emitLnAndSpaces(indent);
            } else if (c == ']' || c == '}') {
                indent -= 2;
                emitLnAndSpaces(indent);
                emit(c);
            } else if (c == ',') {
                emit(c);
                emitLnAndSpaces(indent);
            } else {
                emit(c);
            }
        }
        emitLn();
    }


    private static void emit(char c) {
        System.out.print(c);
    }

    private static void emitLn() {
        System.out.println();
    }

    private static void emitSpaces(int numSpaces) {
        for (int i = 0; i < numSpaces; i++) {
            System.out.print(' ');
        }
    }

    private static void emitLnAndSpaces(int numSpaces) {
        emitLn();
        emitSpaces(numSpaces);
    }
}

