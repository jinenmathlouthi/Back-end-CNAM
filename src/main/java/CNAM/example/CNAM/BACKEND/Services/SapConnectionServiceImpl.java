package CNAM.example.CNAM.BACKEND.Services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;

import CNAM.example.CNAM.BACKEND.Models.SAPRFCTableField;
import CNAM.example.CNAM.BACKEND.Models.SAPTableField;
import CNAM.example.CNAM.BACKEND.Models.usr02;

@Service("sapConnectionService")
public class SapConnectionServiceImpl implements SapConnectionService {
        @Override
        public boolean createSapConnection() throws Exception {

                System.out.println("Start SAP Connection : " + LocalDateTime.now());

                Properties connectProperties = new Properties();

                String rfcdelimiter = "~";

                MyJcoDestinationProvider destinationDataProvider = MyJcoDestinationProvider.getInstance();

                if (!Environment.isDestinationDataProviderRegistered()) {

                        Environment.registerDestinationDataProvider(destinationDataProvider);

                }

                connectProperties
                                .setProperty(
                                                DestinationDataProvider.JCO_ASHOST, "10.1.5.44");

                connectProperties
                                .setProperty(
                                                DestinationDataProvider.JCO_SYSNR, "01");

                connectProperties
                                .setProperty(
                                                DestinationDataProvider.JCO_CLIENT, "500");

                connectProperties
                                .setProperty(
                                                DestinationDataProvider.JCO_USER, "mohamed.da");
                connectProperties
                                .setProperty(
                                                DestinationDataProvider.JCO_PASSWD, "abc123DEF.");
                connectProperties
                                .setProperty(
                                                DestinationDataProvider.JCO_SAPROUTER,
                                                "/H/20.231.18.174/W/112233445566");
                connectProperties
                                .setProperty(
                                                DestinationDataProvider.JCO_LANG, "en");
                String pattern = "dd_MM_yyyy_HH_mm_ss_SSS";
                DateFormat df = new SimpleDateFormat(pattern);
                Date today = Calendar.getInstance().getTime();
                String nowAsString = df.format(today);
                String destname = "treakor_" + nowAsString;
                destinationDataProvider.addDestinationByName(destname, connectProperties);
                try {
                        JCoDestination destination = JCoDestinationManager.getDestination(destname);
                        System.out.println("Pinging destination : " + destination);
                        destination.ping();
                        System.out.println("End SAP Connection : " + LocalDateTime.now());
                        destinationDataProvider.deleteDestinationByName(destname);
                        return true;
                } catch (JCoException e) {
                        destinationDataProvider.deleteDestinationByName(destname);
                        throw e;
                } catch (Exception e) {
                        destinationDataProvider.deleteDestinationByName(destname);
                        throw e;
                }
        }

        @Override
        public List<usr02> getUsers() throws Exception {

                System.out.println("Start SAP Connection : " + LocalDateTime.now());

                Properties connectProperties = new Properties();

                String rfcdelimiter = "~";

                MyJcoDestinationProvider destinationDataProvider = MyJcoDestinationProvider.getInstance();

                if (!Environment.isDestinationDataProviderRegistered()) {

                        Environment.registerDestinationDataProvider(destinationDataProvider);

                }

                connectProperties
                                .setProperty(
                                                DestinationDataProvider.JCO_ASHOST, "10.1.5.44");

                connectProperties
                                .setProperty(
                                                DestinationDataProvider.JCO_SYSNR, "01");

                connectProperties
                                .setProperty(
                                                DestinationDataProvider.JCO_CLIENT, "500");

                connectProperties
                                .setProperty(
                                                DestinationDataProvider.JCO_USER, "mohamed.da");
                connectProperties
                                .setProperty(
                                                DestinationDataProvider.JCO_PASSWD, "abc123DEF.");
                connectProperties
                                .setProperty(
                                                DestinationDataProvider.JCO_SAPROUTER,
                                                "/H/20.231.18.174/W/112233445566");
                connectProperties
                                .setProperty(
                                                DestinationDataProvider.JCO_LANG, "en");
                String pattern = "dd_MM_yyyy_HH_mm_ss_SSS";
                DateFormat df = new SimpleDateFormat(pattern);
                Date today = Calendar.getInstance().getTime();
                String nowAsString = df.format(today);
                String destname = "treakor_" + nowAsString;
                destinationDataProvider.addDestinationByName(destname, connectProperties);
                List<usr02> listUsr02 = new ArrayList<>();
                try {
                        JCoDestination destination = JCoDestinationManager.getDestination(destname);
                        System.out.println("Pinging destination : " + destination);
                        destination.ping();
                        System.out.println("End SAP Connection : " + LocalDateTime.now());
                        List<SAPTableField> _tablefields = new ArrayList<SAPTableField>();
                        JCoFunction functionDDIF_FIELDINFO_GET = destination.getRepository()
                                        .getFunction("DDIF_FIELDINFO_GET");

                        List<SAPRFCTableField> _rfctablefields = new ArrayList<SAPRFCTableField>();
                        functionDDIF_FIELDINFO_GET.getImportParameterList().setValue("TABNAME", "USR02");

                        functionDDIF_FIELDINFO_GET.execute(destination);

                        JCoTable tableDDIF_FIELDINFO_GET = functionDDIF_FIELDINFO_GET.getTableParameterList()
                                        .getTable("DFIES_TAB");

                        for (int iDDIF_FIELDINFO_GET = 0; iDDIF_FIELDINFO_GET < tableDDIF_FIELDINFO_GET
                                        .getNumRows(); iDDIF_FIELDINFO_GET++) {

                                tableDDIF_FIELDINFO_GET.setRow(iDDIF_FIELDINFO_GET);

                                _tablefields.add(new SAPTableField(
                                                tableDDIF_FIELDINFO_GET.getField("TABNAME").getString(),

                                                tableDDIF_FIELDINFO_GET.getField("FIELDNAME").getString(),

                                                Integer.parseInt(tableDDIF_FIELDINFO_GET.getField("POSITION")
                                                                .getString()),

                                                Integer.parseInt(tableDDIF_FIELDINFO_GET.getField("LENG").getString()),

                                                tableDDIF_FIELDINFO_GET.getField("DATATYPE").getString(),

                                                tableDDIF_FIELDINFO_GET.getField("CONVEXIT").getString(), false));

                        }

                        int _countfields = tableDDIF_FIELDINFO_GET.getNumRows();

                        JCoFunction functionRFC_READ_TABLE_CHECKTEXTTABLE = destination.getRepository()
                                        .getFunction("RFC_READ_TABLE");

                        functionRFC_READ_TABLE_CHECKTEXTTABLE.getImportParameterList().setValue("QUERY_TABLE", "DD08L");

                        functionRFC_READ_TABLE_CHECKTEXTTABLE.getImportParameterList().setValue("DELIMITER",
                                        rfcdelimiter);

                        functionRFC_READ_TABLE_CHECKTEXTTABLE.getImportParameterList().setValue("ROWSKIPS",
                                        Integer.valueOf(0));

                        JCoTable tableoptionsRFC_READ_TABLE_CHECKTEXTTABLE = functionRFC_READ_TABLE_CHECKTEXTTABLE
                                        .getTableParameterList().getTable("OPTIONS");

                        tableoptionsRFC_READ_TABLE_CHECKTEXTTABLE.appendRow();

                        tableoptionsRFC_READ_TABLE_CHECKTEXTTABLE.setValue("TEXT", "CHECKTABLE like 'USR02'");

                        tableoptionsRFC_READ_TABLE_CHECKTEXTTABLE.appendRow();

                        tableoptionsRFC_READ_TABLE_CHECKTEXTTABLE.setValue("TEXT", "AND FRKART like 'TEXT'");

                        functionRFC_READ_TABLE_CHECKTEXTTABLE.execute(destination);

                        JCoTable tabledataRFC_READ_TABLE_CHECKTEXTTABLE = functionRFC_READ_TABLE_CHECKTEXTTABLE
                                        .getTableParameterList().getTable("DATA");

                        if (tabledataRFC_READ_TABLE_CHECKTEXTTABLE.getNumRows() > 0) {

                                tabledataRFC_READ_TABLE_CHECKTEXTTABLE.setRow(0);

                                String textTable = tabledataRFC_READ_TABLE_CHECKTEXTTABLE.getString("WA")
                                                .split(rfcdelimiter, -1)[0];

                                JCoFunction functionDDIF_FIELDINFO_GET_TEXTTABLE = destination.getRepository()
                                                .getFunction("DDIF_FIELDINFO_GET");

                                functionDDIF_FIELDINFO_GET_TEXTTABLE.getImportParameterList().setValue("TABNAME",
                                                textTable);

                                functionDDIF_FIELDINFO_GET_TEXTTABLE.execute(destination);

                                JCoTable tableDDIF_FIELDINFO_GET_TEXTTABLE = functionDDIF_FIELDINFO_GET_TEXTTABLE
                                                .getTableParameterList().getTable("DFIES_TAB");

                                for (int iDDIF_FIELDINFO_GET_TEXTTABLE = 0; iDDIF_FIELDINFO_GET_TEXTTABLE < tableDDIF_FIELDINFO_GET_TEXTTABLE
                                                .getNumRows();

                                                iDDIF_FIELDINFO_GET_TEXTTABLE++) {

                                        tableDDIF_FIELDINFO_GET_TEXTTABLE.setRow(iDDIF_FIELDINFO_GET_TEXTTABLE);

                                        if (!tableDDIF_FIELDINFO_GET_TEXTTABLE.getField("KEYFLAG").getString()
                                                        .equals("X")) {

                                                _tablefields.add(new SAPTableField(
                                                                tableDDIF_FIELDINFO_GET.getField("TABNAME").getString(),

                                                                tableDDIF_FIELDINFO_GET_TEXTTABLE.getField("FIELDNAME")
                                                                                .getString(),

                                                                _countfields,

                                                                Integer.parseInt(tableDDIF_FIELDINFO_GET_TEXTTABLE
                                                                                .getField("LENG").getString()),

                                                                tableDDIF_FIELDINFO_GET_TEXTTABLE.getField("DATATYPE")
                                                                                .getString(),

                                                                tableDDIF_FIELDINFO_GET_TEXTTABLE.getField("CONVEXIT")
                                                                                .getString(),
                                                                false));

                                                _countfields++;

                                        }

                                }

                        }
                        JCoFunction functionRFC_READ_TABLE = destination.getRepository().getFunction("RFC_READ_TABLE");
                        functionRFC_READ_TABLE.getImportParameterList().setValue("QUERY_TABLE", "USR02");
                        JCoTable tablefieldsRFC_READ_TABLE = functionRFC_READ_TABLE.getTableParameterList()
                                        .getTable("FIELDS");
                        tablefieldsRFC_READ_TABLE.appendRow();
                        tablefieldsRFC_READ_TABLE.setValue("FIELDNAME", "BNAME");
                        tablefieldsRFC_READ_TABLE.appendRow();
                        tablefieldsRFC_READ_TABLE.setValue("FIELDNAME", "ACCNT");
                        tablefieldsRFC_READ_TABLE.appendRow();
                        tablefieldsRFC_READ_TABLE.setValue("FIELDNAME", "ANAME");
                        tablefieldsRFC_READ_TABLE.appendRow();
                        tablefieldsRFC_READ_TABLE.setValue("FIELDNAME", "ERDAT");
                        tablefieldsRFC_READ_TABLE.appendRow();
                        tablefieldsRFC_READ_TABLE.setValue("FIELDNAME", "TRDAT");
                        tablefieldsRFC_READ_TABLE.appendRow();
                        tablefieldsRFC_READ_TABLE.setValue("FIELDNAME", "LTIME");
                        functionRFC_READ_TABLE.execute(destination);

                        JCoTable tabledataRFC_READ_TABLE = functionRFC_READ_TABLE.getTableParameterList()
                                        .getTable("DATA");

                        int _rowscount = tabledataRFC_READ_TABLE.getNumRows();
                        for (int ifieldsRFC_READ_TABLE = 0; ifieldsRFC_READ_TABLE < tablefieldsRFC_READ_TABLE
                                                                .getNumRows(); ifieldsRFC_READ_TABLE++) {

                                                        tablefieldsRFC_READ_TABLE.setRow(ifieldsRFC_READ_TABLE);

                                                        _rfctablefields.add(new SAPRFCTableField(
                                                                        tablefieldsRFC_READ_TABLE.getField("FIELDNAME")
                                                                                        .getString(),

                                                                        Integer.parseInt(tablefieldsRFC_READ_TABLE
                                                                                        .getField("OFFSET")
                                                                                        .getString()),

                                                                        Integer.parseInt(tablefieldsRFC_READ_TABLE
                                                                                        .getField("LENGTH")
                                                                                        .getString())));

                                                }
                        System.out.println("Rows executed : " + _rowscount);
                        if (_rowscount > 0) {
                                int currentrow = 0;
                                while (currentrow <= _rowscount - 1) {
                                        tabledataRFC_READ_TABLE.setRow(currentrow);

                                        String sMessage = tabledataRFC_READ_TABLE.getString("WA");
                                        sMessage = String.format("%" + -512 + "s", sMessage);
                                        int j = 0;
                                        usr02 usr02 = new usr02();
                                        for (SAPTableField field : _tablefields) {
                                                
                                                if (!field.getFieldname().equals("MANDT")
                                                                && !field.getFieldname().equals("CLIENT")) {

                                                        SAPRFCTableField _findfield = _rfctablefields.stream()

                                                                        .filter(f -> f.getFieldname()
                                                                                        .equals(field.getFieldname()))

                                                                        .findFirst().orElse(null);

                                                        if (!Objects.isNull(_findfield)) {

                                                                if (_findfield.getFieldname().equals("BNAME")) {
                                                                        usr02.setBNAME(sMessage.substring(
                                                                                        _findfield.getOffset(),
                                                                                        _findfield.getOffset()
                                                                                                        + _findfield.getLength())
                                                                                        .trim());
                                                                }
                                                                if (_findfield.getFieldname().equals("ACCNT")) {
                                                                        usr02.setACCNT(sMessage.substring(
                                                                                        _findfield.getOffset(),
                                                                                        _findfield.getOffset()
                                                                                                        + _findfield.getLength())
                                                                                        .trim());
                                                                }
                                                                if (_findfield.getFieldname().equals("ANAME")) {
                                                                        usr02.setANAME(sMessage.substring(
                                                                                        _findfield.getOffset(),
                                                                                        _findfield.getOffset()
                                                                                                        + _findfield.getLength())
                                                                                        .trim());
                                                                }
                                                                if (_findfield.getFieldname().equals("ERDAT")) {
                                                                        usr02.setERDAT(sMessage.substring(
                                                                                        _findfield.getOffset(),
                                                                                        _findfield.getOffset()
                                                                                                        + _findfield.getLength())
                                                                                        .trim());
                                                                }
                                                                if (_findfield.getFieldname().equals("TRDAT")) {
                                                                        usr02.setTRDAT(sMessage.substring(
                                                                                        _findfield.getOffset(),
                                                                                        _findfield.getOffset()
                                                                                                        + _findfield.getLength())
                                                                                        .trim());
                                                                }
                                                                if (_findfield.getFieldname().equals("LTIME")) {
                                                                        usr02.setLTIME(sMessage.substring(
                                                                                        _findfield.getOffset(),
                                                                                        _findfield.getOffset()
                                                                                                        + _findfield.getLength())
                                                                                        .trim());
                                                                }

                                                        }
                                                }
                                        }
                                        currentrow++;
                                        listUsr02.add(usr02);
                                }
                        }
                        return listUsr02;

                } catch (JCoException e) {
                        destinationDataProvider.deleteDestinationByName(destname);
                        throw e;
                } catch (Exception e) {
                        destinationDataProvider.deleteDestinationByName(destname);
                        throw e;
                }
        }
}
