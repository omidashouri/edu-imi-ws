package edu.imi.ir.eduimiws.utilities;

public enum ExpenseCodes {

    _221(1, 221,"D099908940230FF8DED290869251144C076F99867DD55C15897D7BAEAB4385D9"),
    _222(2, 222,"E26DB13AC288BCCFFC486527ECBCD4B2A2DEEDB34E6F7BD7B2498E23BD06DBF5"),
    _223(3, 223,"57D093943DB07A804DB7DFB1914B7B7DF587953BCF1BAA71847A7B058595F4FC"),
    _245(4, 245,"993A6F9E1C6D6C0FC753DAE5A587091D623ADF2068C14D77B28E3511A0C63A07"),
    _231(5, 231,"08A142BE0920A4807F79AEB140DD8A0C0F412EC444141C727554D617EDE18C6D"),
    _233(6, 233,"DAD9166AED5CF98A4D1834F49BCE2B4BC9D3D32B9ECFC1286D48922FDFDB9169"),
    _232(7, 232,"ED938B85A41A712D3B96ACA913437349238F80B63D4540974BDF54B53E8DF58B"),
    _230(8, 230,"E88340C9C372655EDB0DCA84326A80A8C9460AB9FDCDF41A33086F2B74190F25"),
    _234(8, 234,"E88340C9C372655EDB0DCA84326A80A8C9460AB9FDCDF41A33086F2B74190F25"),
//    _222(9, 222,"91842E74E2BD57F1613A943B2CC48D1016615A70FBBED819694D78403F1875DD"),
    _212(0, 212,"265D5B996E16F64685C68E51DC18457A85595759158EAAEE5CD1C143A0CD0752");


    final int expenseCodeApi;
    final int midProjectCode;
    final String expenseCodePublicId;

    ExpenseCodes(int expenseCodeApi, int midProjectCode, String expenseCodePublicId) {
        this.expenseCodeApi = expenseCodeApi;
        this.midProjectCode = midProjectCode;
        this.expenseCodePublicId = expenseCodePublicId;
    }

    public int getExpenseCodeApi() {
        return expenseCodeApi;
    }

    public int getMidProjectCode() {
        return midProjectCode;
    }

    public String getExpenseCodePublicId() {
        return expenseCodePublicId;
    }

    public static String getExpensePublicIdFromMidProjectCode(int midProjectCode){
        switch (midProjectCode){
            case 221 : return _221.expenseCodePublicId;
            case 222 : return _222.expenseCodePublicId;
            case 223 : return _223.expenseCodePublicId;
            case 245 : return _245.expenseCodePublicId;
            case 231 : return _231.expenseCodePublicId;
            case 233 : return _233.expenseCodePublicId;
            case 232 : return _232.expenseCodePublicId;
            case 230 : return _230.expenseCodePublicId;
            case 234 : return _234.expenseCodePublicId;
            case 212 : return _212.expenseCodePublicId;
            default: return "91842E74E2BD57F1613A943B2CC48D1016615A70FBBED819694D78403F1875DD";
        }
    }
}
