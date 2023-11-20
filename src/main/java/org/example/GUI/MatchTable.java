package org.example.GUI;

import org.example.service.Result;
import org.example.model.Ski;

import javax.swing.table.AbstractTableModel;
import java.util.Comparator;
import java.util.List;

public class MatchTable extends AbstractTableModel {
    private final String[] COLUMNS = new String[]{"Id", "Age group", "Type", "Lenght", "Match score"};
    private List<Result> resultList;

    public MatchTable(List <Result> resultList){
        this.resultList = resultList.stream().sorted(Comparator.comparing(c -> c.getId())).toList();
    }

    @Override
    public int getRowCount() {
        return resultList.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Result result = resultList.get(rowIndex);
        Ski ski = result.getSki();
        return switch (columnIndex){
            case 0 -> result.getId();
            case 1 -> result.getKind();
            case 2 -> ski == null ? "Not assigned" : ski.getType();
            case 3 -> ski == null ? "NOT ASSIGNED" : ski.getLenght();
            case 4 -> String.format("%.2f", result.getScore());
            default -> "-";
        };
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNS[column];
    }
}
