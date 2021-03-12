package main.java.utils;

public class Beautifer {

    public Beautifer(){}

    public String Beautify(String code){
        StringBuilder newCode = new StringBuilder();
        int currentIndent = 0;
        for(char c : code.toCharArray()){
            switch(c) {
                case ';':
                    newCode.append(";\n");
                    newCode.append("\t".repeat(currentIndent));
                    break;
                case '{':
                    newCode.append("{\n");
                    currentIndent++;
                    newCode.append("\t".repeat(currentIndent));
                    break;
                case '}':
                    if(currentIndent > 0)newCode.deleteCharAt(newCode.length() - 1);
                    newCode.append("}\n");
                    currentIndent--;
                    newCode.append("\t".repeat(currentIndent));
                    break;
                default:
                    newCode.append(c);
                    break;
            }
        }
        return newCode.toString();
    }
}
