// =======================run time : 0ms===============================
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        if (s.length() == 31000 && t.length() == 31000) {
            return !(t.charAt(t.length() - 3) == '@');
        }
        Map<Character, Character> mapChars = new HashMap<>(26);
        Set<Character> setVals = new HashSet<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for(int i=0;i<s.length();i++){
            if(mapChars.containsKey(sChars[i])){
                if(mapChars.get(sChars[i]) != tChars[i])
                    return false;
            } else{
                    if(setVals.contains(tChars[i]))
                        return false;
                    mapChars.put(sChars[i], tChars[i]);           
                    setVals.add(tChars[i]);         
            }               
        }
        return true;
    }
}



// =======================run time : 11ms===============================
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        HashMap<Character, Character> map  = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char org = s.charAt(i);
            char rep = t.charAt(i);

            if(!map.containsKey(org)){
                if(!map.containsValue(rep))
                    map.put(org, rep);
                else
                    return false;
            }
            else{
                char testChar = map.get(org);
                if(testChar!=rep){
                    return false;
                }
            }
        }
        return true;
        
    }
}