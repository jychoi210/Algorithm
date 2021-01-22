package DFS.BFS;

public class ParenthesisConversion_before {
    public String solution(String p){
        if(checkCorrect(p)){
            return p;
        }else{
            return conversion(p);
        }
    }

    public boolean checkCorrect(String str){
        int bool = 0;
        for(int i = 0; i < str.length(); i++){
            bool = str.charAt(i) == '(' ? bool+1 : bool-1;

            if(bool < 0){ return false;}
        }
        if(bool == 0){ return true; }
        return false;
    }

    public String reverse(String u){
        String result = "";
        for(int i = 1; i < u.length() - 1; i++){
            result = u.charAt(i) == '(' ? result + ")" : result + "(";
        }
        return result;
    }

    public String conversion(String str){
        int bool = 0;
        String u = "";
        String v = "";
        StringBuilder temp = new StringBuilder();
        if(str.equals("")){
            return "";
        }else{
            for(int i = 0; i < str.length(); i++){
                bool = str.charAt(i) == '(' ? bool+1 : bool-1;

                if(bool == 0){
                    u = str.substring(0,i+1);
                    v = str.substring(i+1);
                    break;
                }
            }
        }

        if(checkCorrect(u)){
            temp.append(u);
            temp.append(conversion(v));
            return String.valueOf(temp);
        }else{
            temp.append("(");
            temp.append(conversion(v));
            temp.append(")");
            temp.append(reverse(u));
            return String.valueOf(temp);
        }
    }
}
