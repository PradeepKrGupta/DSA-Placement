// class Solution {
//     static boolean vis[][];
//     public boolean exist(char[][] board, String word) {
//         int n = board.length;
//         int m = board[0].length;
//         vis = new boolean[n][m];

//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(word.charAt(0)==board[i][j] && wordSearch(board, word, i, j, 0)){
//                     return true;
//                 }

//             }
//         }
//         return false;

//     }
//     private boolean wordSearch(char[][] board, String word, int i, int j, int idx){
//         if(idx==word.length()){
//             return true;
//         }

//         if(i>=board.length || i<0 || j>=board[i].length || j<0 || board[i][j]!=word.charAt(idx) || vis[i][j]){
//             return false;
//         }
//         vis[i][j] = true;
//         if(wordSearch(board, word, i+1, j, idx+1)||
//             wordSearch(board, word, i-1, j, idx+1)||
//             wordSearch(board, word, i, j+1, idx+1)||
//             wordSearch(board, word, i, j-1, idx+1)){
//                 return true;
//         }
//         vis[i][j]=false;
//         return false;

//     }
// }

