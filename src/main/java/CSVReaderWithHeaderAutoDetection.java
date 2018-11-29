import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class CSVReaderWithHeaderAutoDetection {
    private static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\BRITENET\\Documents\\SoapUI\\api-soapui\\test_data\\TC2_getAccountNumberForCard - valid data.csv";

    public static void main(String[] args) throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withTrim());

        final Map<String, Integer> headerMap = csvParser.getHeaderMap();
        List<CSVRecord> recordList = csvParser.getRecords();
        System.out.println("recordList " + recordList.size() + "\n");
        CSVRecord csvRecord = recordList.get(1);

        for (final String label : headerMap.keySet()) {
            System.out.println(label + ": " + csvRecord.get(label));
        }
        System.out.println("\n");
    }

}
