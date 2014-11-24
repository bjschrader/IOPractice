package iopractice;

import java.io.*;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author schra_000
 */
public class MailingLabelConsoleOutput implements Comparable<MailingLabelConsoleOutput> {

    private List<String> mailLabel;
    public static int outputCount = 0;
    private int count;

    public MailingLabelConsoleOutput() {
        outputCount++;
        count = outputCount;
    }
    
    public final void outputData(List<String> list){
        mailLabel = list;
        int lineNumber = 0;
        for (int i = 0; i < mailLabel.size(); i++){
            String result = mailLabel.get(i).replaceAll(",", "");
            String[] fileLines = result.split(" ");
            
            if (lineNumber <= 2){
                if (lineNumber == 0){
                    System.out.println("First Name: " + fileLines[0]);
                    System.out.println("Last Name: " + fileLines[1]);
                    lineNumber++;
                }else if (lineNumber == 1){
                    System.out.println("Address " + result);
                    lineNumber++;
                }else if (lineNumber ==2){
                    String[] temp = fileLines[0].split(",");
                    System.out.println("City: " + fileLines[0]);
                    System.out.println("State : " + fileLines[1]);
                    System.out.println("Zip Code: " + fileLines[2] + "\n");
                    lineNumber++;
                }
            }else{
                    lineNumber = 0;
                }
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.mailLabel);
        hash = 79 * hash + this.count;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MailingLabelConsoleOutput other = (MailingLabelConsoleOutput) obj;
        if (!Objects.equals(this.mailLabel, other.mailLabel)) {
            return false;
        }
        if (this.count != other.count) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MailingLabelConsoleOutput{" + "mailLabel=" + mailLabel + ", count=" + count + '}';
    }
    
    

    @Override
    public int compareTo(MailingLabelConsoleOutput output) {
        int result;

        if (this.count == output.count) {
            result = 0;
        } else if (this.count < output.count) {
            result = -1;
        } else {
            result = 1;
        }
        return result;
    }

}
