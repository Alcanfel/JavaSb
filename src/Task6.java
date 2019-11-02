class Task6{
    public static void main(String[] args){
		unionString("abcddg", "andfgha");
		unionString("aaabbcc", "ccadf");
		unionString("ghsss", "aafhj");
		unionString("aaaeee", "eea");
		unionString("abbv", "kllii");
        		
    }
	public static void unionString(String a, String b){
		String str_concat = a.concat(b);
        StringBuilder result = new StringBuilder();
		char[] chr_str_contact = str_concat.toCharArray();
        for (int i = 0; i < str_concat.length() ;i++){
            if (result.indexOf(String.valueOf(chr_str_contact[i])) == -1) result.append(chr_str_contact[i]);
        }
        System.out.format("Объединение строк без дублирования символов!\nСтрока 1:%s \nСтрока 2:%s \nРезультат: %s \n",a, b, result);
	}
}