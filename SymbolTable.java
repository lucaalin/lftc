package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SymbolTable {

    private List<Map.Entry<Integer, String>> symbolTableEntries;

    public SymbolTable() {
        symbolTableEntries = new ArrayList<>();
    }

    /**
     * Method verifying if the value provided as input is found in the ST
     * @param valueItem the value to be searched for
     * @return true if value is found, false otherwise
     */
    public boolean containsValue(String valueItem) {
        for (Map.Entry<Integer, String> entry : symbolTableEntries) {
            if (entry.getValue().equals(valueItem)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that inserts the given symbol with the corresponding index alphabetically in the ST
     * @param index position in the ST
     * @param symbol symbol in the ST - can be either a variable or a constant
     */
    public void put(int index, String symbol) {
        Map.Entry<Integer, String> newTuple = Map.entry(index, symbol);
        int insertionIndex = 0;
        for (int i = 0; i < symbolTableEntries.size(); i++) {
            Map.Entry<Integer, String> existingEntry = symbolTableEntries.get(i);
            Map.Entry<Integer, String> nextTuple = null;
            if (i + 1 < symbolTableEntries.size()) {
                // sortedTable still has elements
                nextTuple = symbolTableEntries.get(i + 1);
            }
            if (symbol.compareTo(existingEntry.getValue()) < 0) {
                // Given tuple key is higher in the alphabet then the first one from the table
                symbolTableEntries.add(newTuple);
                return;
            } else if (symbol.compareTo(existingEntry.getValue()) == 0) {
                // If the entry key already exists, replace it with the new symbol code
                symbolTableEntries.remove(insertionIndex);
                symbolTableEntries.add(insertionIndex, newTuple);
                return;
            } else if ((nextTuple != null && !nextTuple.getValue().equals(existingEntry.getValue())) &&
                    // table has a least 2 elements and end of the table is not reached
                    (symbol.compareTo(existingEntry.getValue()) > 0 && symbol.compareTo(nextTuple.getValue()) < 0)) { // new key can be placed between 2 elements
                symbolTableEntries.add(insertionIndex, newTuple);
                return;
            }
            insertionIndex++;
        }
        symbolTableEntries.add(newTuple);
    }

    /**
     * Method receives a symbol and returns its position in the ST
     * @param symbol to be searched for
     * @return integer position for symbol in ST
     */
    public Integer getPosition(String symbol) {
        for (Map.Entry<Integer, String> tableEntry : symbolTableEntries) {
            System.out.println(tableEntry.getKey() + " " + tableEntry.getValue());
            if (tableEntry.getValue().equals(symbol)) {
                return tableEntry.getKey();
            }
        }
        return -1;
    }

    /**
     * Display ST
     */
    public void printSymbolTable() {
        if (symbolTableEntries.size() != 0) {
            System.out.println("Symbol Table");
        }
        for (Map.Entry<Integer, String> tableEntry : symbolTableEntries) {
            System.out.println(tableEntry.getKey() + " " + tableEntry.getValue());
        }
    }
}
