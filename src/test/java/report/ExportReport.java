package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExportReport {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        //verifica se o relatório ainda não foi criado
        if (extent == null) {

            //tipo de relatorio(Sprk = html)
            //caminho do arquivo, onde o arquivo html sera gerado
            ExtentSparkReporter spark = new ExtentSparkReporter("target/Relatorio-extent.html");

            spark.config().setReportName("Relatório da Automação"); // nome exibidio dentro do relatorio
            spark.config().setDocumentTitle("Testes Selenium");

            extent = new ExtentReports(); //instancia do objeto principal, atraves dele podemos criar teste, registrar status e adicionar logs
            extent.attachReporter(spark); // IMPORTANTE: Diz ao Extentreports(use o spark como formato de saida)
        }
        return extent;
    }
}
