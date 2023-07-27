package support;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class Reusable {
    public static String read_Properties_File(String key)
    {
        String value=null;
        try
        {
            FileReader read=new FileReader(System.getProperty("user.dir")+"\\testData.properties");
            Properties prop=new Properties();
            prop.load(read);
            value=prop.getProperty(key);
        }
        catch (Exception e)  { e.printStackTrace(); }
        return value;
    }

    public static String read_Excel(String testcasename,String param)
    {
        String excel_data=null;
        try{

            String excel_path=read_Properties_File("excel_path");
            String excel_sheet_name=read_Properties_File("Pet_Validation");
            FileInputStream fls=new FileInputStream(excel_path);
            Workbook workbook=new XSSFWorkbook(fls);
            Sheet sheet=workbook.getSheet(excel_sheet_name);
            int RC_count=sheet.getLastRowNum();
            for (int i=0;i<=RC_count;i++)
            {
                Row row=sheet.getRow(i);
                int Col_count=row.getLastCellNum();
                Cell cell=row.getCell(0);
                String value=cell.getStringCellValue();
                if(value.equals(testcasename))
                {

                    Row newrow=sheet.getRow(0);

                    for(int j=0;j<Col_count;j++)
                    {
                        Cell cellnum=newrow.getCell(j);
                        String valueofcell=cellnum.getStringCellValue();
                        if(valueofcell.equals(param))
                        {
                            excel_data=sheet.getRow(i).getCell(j).toString();
                        }


                    }
                }
            }
        }
        catch (Exception e)
        {

        }
        return excel_data;
    }

    public static String creatPait_Req_Body(String Pet_Id,String Pet_Name)
    {
        String body="{\n" +
                "    \"id\": "+Pet_Id+",\n" +
                "    \"category\": {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    },\n" +
                "    \"name\": \""+Pet_Name+"\",\n" +
                "    \"photoUrls\": [\n" +
                "      \"string\"\n" +
                "    ],\n" +
                "    \"tags\": [\n" +
                "      {\n" +
                "        \"id\": 0,\n" +
                "        \"name\": \"string\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"status\": \"available\"\n" +
                "  }";
        return body;

    }

    public static int floattoint(String petID){
        float f = Float.parseFloat(petID);
        return (int)f;
    }




}
