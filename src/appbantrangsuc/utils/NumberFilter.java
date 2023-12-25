package appbantrangsuc.utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class NumberFilter<T> extends DocumentFilter {

    private final Class<T> anoClass;
    private FilterMessage filterMessage;

    public void setFilterMessage(FilterMessage filterMessage) {
        this.filterMessage = filterMessage;
    }
    

    public NumberFilter(Class<T> anoClass) {
        this.anoClass = anoClass;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string,
            AttributeSet attr) throws BadLocationException {

        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder();
        sb.append(doc.getText(0, doc.getLength()));
        sb.insert(offset, string);

        if (test(sb.toString())) {
            super.insertString(fb, offset, string, attr);
            if (filterMessage != null) {
                filterMessage.onInsertSuccess();
            }
        } else {
            // warn the user and don't allow the insert
            if (filterMessage != null) {
                filterMessage.onInsertFailed();
            }
        }
    }

    private boolean test(String text) {
        if (text.isEmpty()) {
            return true;
        }
        try {
            if (this.anoClass == Integer.class) {
                Integer.parseInt(text);
            } else if (this.anoClass == Float.class) {
                Float.parseFloat(text);
            } else if (this.anoClass == Double.class) {
                Double.parseDouble(text);
            } else if (this.anoClass == Long.class) {
                Long.parseLong(text);
            } else {
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text,
            AttributeSet attrs) throws BadLocationException {

        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder();
        sb.append(doc.getText(0, doc.getLength()));
        sb.replace(offset, offset + length, text);

        if (test(sb.toString())) {
            super.replace(fb, offset, length, text, attrs);
            if (filterMessage != null) {
                filterMessage.onReplaceSuccess();
            }
        } else {
            // warn the user and don't allow the insert
            if (filterMessage != null) {
                filterMessage.onReplaceFailed();
            }
        }

    }

    @Override
    public void remove(FilterBypass fb, int offset, int length)
            throws BadLocationException {
        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder();
        sb.append(doc.getText(0, doc.getLength()));
        sb.delete(offset, offset + length);

        if (test(sb.toString())) {
            super.remove(fb, offset, length);
            if (filterMessage != null) {
                filterMessage.onRemoveSuccess();
            }
        } else {
            // warn the user and don't allow the insert
            if (filterMessage != null) {
                filterMessage.onRemoveFailed();
            }
        }

    }
    
    public interface FilterMessage {
        default void onInsertFailed(){}
        default void onRemoveFailed(){}
        default void onReplaceFailed(){}
        default void onInsertSuccess(){}
        default void onRemoveSuccess(){}
        default void onReplaceSuccess(){}
        
    }
}
