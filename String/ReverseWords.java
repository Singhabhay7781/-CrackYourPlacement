class Solution {
    public String reverseWords(String s) {
        //approach 1
        // String words[] = s.trim().split("\\s+");

        // StringBuilder sb = new StringBuilder();

        // for(int i=words.length-1;i>=0;i--){
        //     sb.append(words[i]);
        //     sb.append(" ");
        // }

        // return sb.substring(0,sb.length()-1).toString();

        //approach 2
        char[] chars = s.toCharArray();
        int n = chars.length;
        reverse(chars,0,n-1);
        int l = 0, r = 0, i = 0;

        while (i < n) {
            // Copy the characters of the word
            while (i < n && chars[i] != ' ') {
                chars[r++] = chars[i++];
            }
            // Reverse the word
            if (l < r) {
                reverse(chars, l, r - 1);
               if (r < n) {
                    chars[r++] = ' ';
                }
                l = r;
            }
            i++;
        }
        //Remove the trailing space
        return new String(chars).substring(0, r > 0 && chars[r - 1] == ' ' ? r - 1 : r);
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}