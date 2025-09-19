class Spreadsheet {
    int[][] sheet;
    public Spreadsheet(int rows) {
        sheet = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        String colStr = cell.substring(0, 1);
        String rowStr = cell.substring(1, cell.length());

        int col = colStr.charAt(0) - 'A';
        int row = Integer.parseInt(rowStr) - 1;

        sheet[row][col] = value;
    }
    
    public void resetCell(String cell) {
        String colStr = cell.substring(0, 1);
        String rowStr = cell.substring(1, cell.length());

        int col = colStr.charAt(0) - 'A';
        int row = Integer.parseInt(rowStr) - 1;

        sheet[row][col] = 0;
    }
    
    public int getValue(String formula) {
        String newFormula = formula.substring(1, formula.length());

        String[] str = newFormula.split("\\+");
        int[] index = new int[str.length];
        
        for(int i = 0; i < str.length; i++){
            String curr = str[i];
            if(curr.charAt(0) >= 'A' && curr.charAt(0) <= 'Z'){
                String colStr = curr.substring(0, 1);
                String rowStr = curr.substring(1, curr.length());

                int col = colStr.charAt(0) - 'A';
                int row = Integer.parseInt(rowStr) - 1;

                index[i] = sheet[row][col];
            }else{
                index[i] = Integer.parseInt(curr);
            }
        }
        int result = 0;
        for(int i = 0; i < str.length; i++){
            result += index[i];
        }

        return result;

    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */