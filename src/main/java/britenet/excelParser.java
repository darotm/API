package britenet;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class excelParser {
    public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\BRITENET\\Documents\\SoapUI\\api-soapui\\test_data\\MPTAPI CORE.xls";

    public static void main(String[] args) throws IOException {

        //LinkedHashMap<String, String> names = new LinkedHashMap<>();
        String[] names = {"a","b"};

        List<String> methods = Arrays.asList(names);
        LinkedList test = new LinkedList(Arrays.asList(names));
        System.out.println();


    }
}
