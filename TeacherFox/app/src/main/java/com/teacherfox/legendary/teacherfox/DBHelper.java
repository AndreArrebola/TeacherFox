package com.teacherfox.legendary.teacherfox;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by andre on 11/09/16.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "bancoquestoes.db";
    public static final String TABLE_NAME = "quests";
    private static final int DATABASE_VERSION = 5;
    public static final String ID = "_id";
    public static final String ENUNC     = "enunc";
    public static final String ALTA = "alta";
    public static final String ALTB = "altb";
    public static final String ALTC = "altc";
    public static final String ALTD = "altd";
    public static final String ALTE = "alte";
    public static final String ALTOK = "altok";
    public static final String COINS = "coins";
    public static final String MATERIA="materia";
    private String[] allColumns = { DBHelper.ID, DBHelper.ALTA, DBHelper.ENUNC,
            DBHelper.ALTB, DBHelper.ALTC, DBHelper.ALTD, DBHelper.ALTE, DBHelper.COINS, DBHelper.MATERIA, DBHelper.ALTOK};
    private static final String CRIAR_TABELA="create table " + TABLE_NAME + "(" +
            ID + " integer primary key autoincrement, " +
            ENUNC + " text not null, " +
            ALTA + " text not null, " +
            ALTB + " text not null, " +
            ALTC + " text not null, " +
            ALTD + " text not null, " +
            ALTE + " text not null, " +
            COINS + " integer not null, " +
            MATERIA + " text, " +
            ALTOK + " text not null);";

    public DBHelper(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CRIAR_TABELA);
        ContentValues values = new ContentValues();
        values.put(DBHelper.ENUNC, "Os dois principais rios que alimentavam o Mar de " +
                "Aral, Amurdarya e Sydarya, mantiveram o nível e o " +
                "volume do mar por muitos séculos. Entretanto, o projeto " +
                "de estabelecer e expandir a produção de algodão " +
                "irrigado aumentou a dependência de várias repúblicas " +
                "da Ásia Central da irrigação e monocultura. O aumento " +
                "da demanda resultou no desvio crescente de água para " +
                "a irrigação, acarretando redução drástica do volume de " +
                "tributários do Mar de Aral. Foi criado na Ásia Central um " +
                "novo deserto, com mais de 5 milhões de hectares, como " +
                "resultado da redução em volume. " +
                "\n" +
                "A intensa interferência humana na região descrita " +
                "provocou o surgimento de uma área desértica em " +
                "decorrência da");
        values.put(DBHelper.ALTA, "A erosão.");
        values.put(DBHelper.ALTB, "B salinização .");
        values.put(DBHelper.ALTC, "C laterização.");
        values.put(DBHelper.ALTD, "D compactação.");
        values.put(DBHelper.ALTE, "E sedimentação.");
        values.put(DBHelper.ALTOK, "B salinização .");
        values.put(DBHelper.MATERIA, "Geografia");
        values.put(DBHelper.COINS, 25);
        db.insert(TABLE_NAME, null, values );
        values.put(DBHelper.ENUNC, "É o caráter radical do que se procura que exige a " +
                "radicalização do próprio processo de busca. Se todo o " +
                "espaço for ocupado pela dúvida, qualquer certeza que " +
                "aparecer a partir daí terá sido de alguma forma gerada " +
                "pela própria dúvida, e não será seguramente nenhuma " +
                "daquelas que foram anteriormente varridas por essa " +
                "mesma dúvida." +
                "\n" +
                "Apesar de questionar os conceitos da tradição, a dúvida " +
                "radical da filosofia cartesiana tem caráter positivo por" +
                "contibuir para o(a)");
        values.put(DBHelper.ALTA, "A dissolução do saber científico.");
        values.put(DBHelper.ALTB, "B recuperação dos antigos juízos.");
        values.put(DBHelper.ALTC, "C exaltação do pensamento clássico.");
        values.put(DBHelper.ALTD, "D surgimento do conhecimento inabalável .");
        values.put(DBHelper.ALTE, "E fortalecimento dos preconceitos religiosos.");
        values.put(DBHelper.ALTOK, "D surgimento do conhecimento inabalável .");
        values.put(DBHelper.MATERIA, "Filosofia");
        values.put(DBHelper.COINS, 25);
        db.insert(TABLE_NAME, null, values );
        values.put(DBHelper.ENUNC, "      Ao deflagar-se a crise mundial de 1929, a situação " +
                "da economia cafeeira se apresentava como se segue. " +
                "A produção, que se encontrava em altos níveis, " +
                "teria que seguir crescendo, pois os produtores " +
                "haviam continuado a expandir as plantações até " +
                "aquele momento. Com efeito, a produção máxima " +
                "seria alcançada em 1933, ou seja, no ponto mais baixo " +
                "da depressão, como reflexo das grandes plantações de " +
                "1927-1928. Entretanto, era totalmente impossível obter " +
                "créditos do exterior para financiar a retenção de novos " +
                "estoques, pois o mercado internacional de capitais " +
                "se encontrava em profunda depressão, e o crédito do " +
                "governo desaparecera com a evaporação das reservas. " +
                "\n" +
                "Uma resposta do Estado brasileiro à conjuntura " +
                "econômica mencionada foi o(a)");
        values.put(DBHelper.ALTA, "A atração de empresas estrangeiras.");
        values.put(DBHelper.ALTB, "B reformulação do sistema fundiário.");
        values.put(DBHelper.ALTC, "C incremento da mão de obra imigrante.");
        values.put(DBHelper.ALTD, "D desenvolvimento de política industrial .");
        values.put(DBHelper.ALTE, "E financiamento de pequenos agricultures.");
        values.put(DBHelper.ALTOK, "D desenvolvimento de política industrial .");
        values.put(DBHelper.MATERIA, "Português");
        values.put(DBHelper.COINS, 20);
        db.insert(TABLE_NAME, null, values );
        values.put(DBHelper.ENUNC, "Mas plantar pra dividir\n" +
                "Não faço mais isso, não.\n" +
                "Eu sou um pobre caboclo,\n" +
                "Ganho a vida na enxada.\n" +
                "O que eu colho é dividido\n" +
                "Com quem não planta nada.\n" +
                "Se assim continuar\n" +
                "vou deixar o meu sertão,\n" +
                "mesmo os olhos cheios d'água\n" +
                "e com dor no coração.\n" +
                "Vou pro Rio carregar massas\n" +
                "pros pedreiros em construção.\n" +
                "Deus até está ajudando:\n" +
                "está chovendo no sertão!\n" +
                "Mas plantar pra dividir,\n" +
                "Não faço mais isso, não.\n" +
                "\n" +
                "No trecho da canção, composta na década de 1960, " +
                "retrata-se a insatisfação do trabalhador rural com");
        values.put(DBHelper.ALTA, "A a distribuição desigual da produção .");
        values.put(DBHelper.ALTB, "B os financiamentos feitos ao produtor rural.");
        values.put(DBHelper.ALTC, "C a ausência de escolas técnicas no campo.");
        values.put(DBHelper.ALTD, "D os empecilhos advindos das secas prolongadas.");
        values.put(DBHelper.ALTE, "E a precariedade de insumos no trabalho do campo.");
        values.put(DBHelper.ALTOK, "A a distribuição desigual da produção .");
        values.put(DBHelper.MATERIA, "Português");
        values.put(DBHelper.COINS, 15);
        db.insert(TABLE_NAME, null, values );
        values.put(DBHelper.ENUNC, "O cidadão norte-americano desperta num leito " +
                "construído segundo padrão originário do Oriente Próximo, " +
                "mas modificado na Europa Setentrional antes de ser " +
                "transmitido à América. Sai debaixo de cobertas feitas " +
                "de algodão cuja planta se tornou doméstica na Índia. " +
                "No restaurante, toda uma série de elementos tomada de " +
                "empréstimo o espera. O prato é feito de uma espécie de " +
                "cerâmica inventada na China. A faca é de aço, liga feita " +
                "pela primeira vez na Índia do Sul; o garfo é inventado " +
                "na Itália medieval; a colher vem de um original romano. " +
                "Lê notícias do dia impressas em caracteres inventados " +
                "pelos antigos semitas, em material inventado na China e " +
                "por um processo inventado na Alemanha.\n" +
                "\n" +
                "A situação descrita é um exemplo de como os costumes " +
                "resultam da");
        values.put(DBHelper.ALTA, "A assimilação de valores de povos exóticos.");
        values.put(DBHelper.ALTB, "B experimentação de hábitos sociais variados.");
        values.put(DBHelper.ALTC, "C recuperação de heranças da Antiguidade Clássica.");
        values.put(DBHelper.ALTD, "D fusão de elementos de tradições culturais diferentes .");
        values.put(DBHelper.ALTE, "E valorização de comportamento de grupos privilegiados");
        values.put(DBHelper.ALTOK, "D fusão de elementos de tradições culturais diferentes .");
        values.put(DBHelper.MATERIA, "História");
        values.put(DBHelper.COINS, 20);
        db.insert(TABLE_NAME, null, values );
        values.put(DBHelper.ENUNC, "O jovem espanhol Daniel se sente perdido. " +
                "Seu diploma de desenhista industrial e seu alto " +
                "conhecimento de inglês devem ajudá-lo a tomar um " +
                "rumo. Mas a taxa de desemprego, que supera 52% " +
                "entre os que têm menos de 25 anos, o desnorteia. " +
                "Ele está convencido de que seu futuro profissional " +
                "não está na Espanha, como o de, pelo menos, 120 mil " +
                "conterrâneos que emigraram nos últimos dois anos. " +
                "O irmão dele, que é engenheiro-agrônomo, conseguiu " +
                "emprego no Chile. Atualmente, Daniel participa de " +
                "uma oficina de procura de emprego em países como " +
                "Brasil, Alemanha e China. A oficina é oferecida por " +
                "uma universidade espanhola.\n" +
                "\n" +
                "A situação ilustra uma crise econômica que implica");
        values.put(DBHelper.ALTA, "A valorização do trabalho fabril.");
        values.put(DBHelper.ALTB, "B expansão dos mercados tecnológicos.");
        values.put(DBHelper.ALTC, "C expansão dos recursos tecnológicos .");
        values.put(DBHelper.ALTD, "D diversificação dos mercados produtivos.");
        values.put(DBHelper.ALTE, "E intensificação dos intercâmbios estudantis.");
        values.put(DBHelper.ALTOK, "C expansão dos recursos tecnológicos .");
        values.put(DBHelper.MATERIA, "Geografia");
        values.put(DBHelper.COINS, 25);
        db.insert(TABLE_NAME, null, values );
        values.clear();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
