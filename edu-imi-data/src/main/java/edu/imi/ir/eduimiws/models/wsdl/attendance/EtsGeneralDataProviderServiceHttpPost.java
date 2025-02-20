package edu.imi.ir.eduimiws.models.wsdl.attendance;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 4.1.0
 * 2025-01-31T12:06:54.486+03:30
 * Generated source version: 4.1.0
 *
 */
@WebService(targetNamespace = "http://tempuri.org/", name = "EtsGeneralDataProviderServiceHttpPost")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface EtsGeneralDataProviderServiceHttpPost {

    @WebMethod(operationName = "AddSpecialExtraWorkPermission")
    @WebResult(name = "string", targetNamespace = "http://tempuri.org/", partName = "Body")
    public String addSpecialExtraWorkPermission(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "value", name = "value", targetNamespace = "http://tempuri.org/")
        String value,
        @WebParam(partName = "periodId", name = "periodId", targetNamespace = "http://tempuri.org/")
        String periodId,
        @WebParam(partName = "requestReason", name = "requestReason", targetNamespace = "http://tempuri.org/")
        String requestReason,
        @WebParam(partName = "description", name = "description", targetNamespace = "http://tempuri.org/")
        String description,
        @WebParam(partName = "specialExtraWorkId", name = "specialExtraWorkId", targetNamespace = "http://tempuri.org/")
        String specialExtraWorkId,
        @WebParam(partName = "organizationChartId", name = "organizationChartId", targetNamespace = "http://tempuri.org/")
        String organizationChartId
    );

    @WebMethod(operationName = "AddMissionRegistrationPermission")
    @WebResult(name = "string", targetNamespace = "http://tempuri.org/", partName = "Body")
    public String addMissionRegistrationPermission(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "missionId", name = "missionId", targetNamespace = "http://tempuri.org/")
        String missionId,
        @WebParam(partName = "missionLocationId", name = "missionLocationId", targetNamespace = "http://tempuri.org/")
        String missionLocationId,
        @WebParam(partName = "missionSubject", name = "missionSubject", targetNamespace = "http://tempuri.org/")
        String missionSubject,
        @WebParam(partName = "beginDateTime", name = "beginDateTime", targetNamespace = "http://tempuri.org/")
        String beginDateTime,
        @WebParam(partName = "endDateTime", name = "endDateTime", targetNamespace = "http://tempuri.org/")
        String endDateTime,
        @WebParam(partName = "requestReason", name = "requestReason", targetNamespace = "http://tempuri.org/")
        String requestReason,
        @WebParam(partName = "description", name = "description", targetNamespace = "http://tempuri.org/")
        String description
    );

    @WebMethod(operationName = "IsValidPersonStringDate")
    @WebResult(name = "boolean", targetNamespace = "http://tempuri.org/", partName = "Body")
    public boolean isValidPersonStringDate(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "dateTime", name = "dateTime", targetNamespace = "http://tempuri.org/")
        String dateTime,
        @WebParam(partName = "requestState", name = "requestState", targetNamespace = "http://tempuri.org/")
        String requestState
    );

    @WebMethod(operationName = "Test")
    @WebResult(name = "string", targetNamespace = "http://tempuri.org/", partName = "Body")
    public String test()
;

    @WebMethod(operationName = "GetIORecordPerPersistOn")
    @WebResult(name = "ArrayOfIoRecordDataModel", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfIoRecordDataModel getIORecordPerPersistOn(

        @WebParam(partName = "fromDate", name = "fromDate", targetNamespace = "http://tempuri.org/")
        String fromDate,
        @WebParam(partName = "toDate", name = "toDate", targetNamespace = "http://tempuri.org/")
        String toDate
    );

    @WebMethod(operationName = "GetFunctionalityList")
    @WebResult(name = "ArrayOfString", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfString getFunctionalityList(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "fromDate", name = "fromDate", targetNamespace = "http://tempuri.org/")
        String fromDate,
        @WebParam(partName = "toDate", name = "toDate", targetNamespace = "http://tempuri.org/")
        String toDate
    );

    @WebMethod(operationName = "AddDailyExtraWorkPermission")
    @WebResult(name = "string", targetNamespace = "http://tempuri.org/", partName = "Body")
    public String addDailyExtraWorkPermission(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "extraWorkId", name = "extraWorkId", targetNamespace = "http://tempuri.org/")
        String extraWorkId,
        @WebParam(partName = "beginDateTime", name = "beginDateTime", targetNamespace = "http://tempuri.org/")
        String beginDateTime,
        @WebParam(partName = "endDateTime", name = "endDateTime", targetNamespace = "http://tempuri.org/")
        String endDateTime,
        @WebParam(partName = "requestReason", name = "requestReason", targetNamespace = "http://tempuri.org/")
        String requestReason,
        @WebParam(partName = "description", name = "description", targetNamespace = "http://tempuri.org/")
        String description
    );

    @WebMethod(operationName = "GetFunctionalityWinPayList")
    @WebResult(name = "PeriodCalculationInfo", targetNamespace = "http://tempuri.org/", partName = "Body")
    public PeriodCalculationInfo getFunctionalityWinPayList(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "date", name = "date", targetNamespace = "http://tempuri.org/")
        String date,
        @WebParam(partName = "withVacation", name = "withVacation", targetNamespace = "http://tempuri.org/")
        String withVacation,
        @WebParam(partName = "withSequenceWorkingDetails", name = "withSequenceWorkingDetails", targetNamespace = "http://tempuri.org/")
        String withSequenceWorkingDetails,
        @WebParam(partName = "withSpecialExtraWork", name = "withSpecialExtraWork", targetNamespace = "http://tempuri.org/")
        String withSpecialExtraWork,
        @WebParam(partName = "withVacationRemaining", name = "withVacationRemaining", targetNamespace = "http://tempuri.org/")
        String withVacationRemaining,
        @WebParam(partName = "withSpecialAddSubVacation", name = "withSpecialAddSubVacation", targetNamespace = "http://tempuri.org/")
        String withSpecialAddSubVacation,
        @WebParam(partName = "withMission", name = "withMission", targetNamespace = "http://tempuri.org/")
        String withMission
    );

    @WebMethod(operationName = "GetAllCurrentlyEmployeesWithKey")
    @WebResult(name = "ArrayOfEmployeeDataModelWithKey", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfEmployeeDataModelWithKey getAllCurrentlyEmployeesWithKey()
;

    @WebMethod(operationName = "GetPeriodCalculationInfo")
    public void getPeriodCalculationInfo(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "fromDate", name = "fromDate", targetNamespace = "http://tempuri.org/")
        String fromDate,
        @WebParam(partName = "toDate", name = "toDate", targetNamespace = "http://tempuri.org/")
        String toDate
    );

    @WebMethod(operationName = "IsValidReserve")
    @WebResult(name = "boolean", targetNamespace = "http://tempuri.org/", partName = "Body")
    public boolean isValidReserve(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "startDateTime", name = "startDateTime", targetNamespace = "http://tempuri.org/")
        String startDateTime,
        @WebParam(partName = "endDateTime", name = "endDateTime", targetNamespace = "http://tempuri.org/")
        String endDateTime,
        @WebParam(partName = "officialHolidaySetting", name = "officialHolidaySetting", targetNamespace = "http://tempuri.org/")
        String officialHolidaySetting,
        @WebParam(partName = "agreedHolidaySetting", name = "agreedHolidaySetting", targetNamespace = "http://tempuri.org/")
        String agreedHolidaySetting,
        @WebParam(partName = "normalDaySetting", name = "normalDaySetting", targetNamespace = "http://tempuri.org/")
        String normalDaySetting,
        @WebParam(partName = "chekExtraWorkPermission", name = "chekExtraWorkPermission", targetNamespace = "http://tempuri.org/")
        String chekExtraWorkPermission
    );

    @WebMethod(operationName = "IsValidPerson")
    @WebResult(name = "boolean", targetNamespace = "http://tempuri.org/", partName = "Body")
    public boolean isValidPerson(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "dateTime", name = "dateTime", targetNamespace = "http://tempuri.org/")
        String dateTime,
        @WebParam(partName = "requestState", name = "requestState", targetNamespace = "http://tempuri.org/")
        String requestState,
        @WebParam(partName = "leaveHour", name = "leaveHour", targetNamespace = "http://tempuri.org/")
        String leaveHour
    );

    @WebMethod(operationName = "GetOrganizationChartIdByEmployeeById")
    @WebResult(name = "long", targetNamespace = "http://tempuri.org/", partName = "Body")
    public long getOrganizationChartIdByEmployeeById(

        @WebParam(partName = "regionId", name = "regionId", targetNamespace = "http://tempuri.org/")
        String regionId,
        @WebParam(partName = "employeeId", name = "employeeId", targetNamespace = "http://tempuri.org/")
        String employeeId
    );

    @WebMethod(operationName = "GetAllExtraWorkPermissionsByDate")
    @WebResult(name = "ArrayOfDailyExtraWorkPermissionDataModel", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfDailyExtraWorkPermissionDataModel getAllExtraWorkPermissionsByDate(

        @WebParam(partName = "date", name = "date", targetNamespace = "http://tempuri.org/")
        String date
    );

    @WebMethod(operationName = "GetDailyMissionsOrVacations")
    @WebResult(name = "string", targetNamespace = "http://tempuri.org/", partName = "Body")
    public String getDailyMissionsOrVacations(

        @WebParam(partName = "startDateTime", name = "startDateTime", targetNamespace = "http://tempuri.org/")
        String startDateTime,
        @WebParam(partName = "endDateTime", name = "endDateTime", targetNamespace = "http://tempuri.org/")
        String endDateTime
    );

    @WebMethod(operationName = "GetAllEmployeesInfo")
    @WebResult(name = "ArrayOfEmployeeInfo", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfEmployeeInfo getAllEmployeesInfo()
;

    @WebMethod(operationName = "AddMissionRegistration")
    @WebResult(name = "string", targetNamespace = "http://tempuri.org/", partName = "Body")
    public String addMissionRegistration(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "missionId", name = "missionId", targetNamespace = "http://tempuri.org/")
        String missionId,
        @WebParam(partName = "beginDateTime", name = "beginDateTime", targetNamespace = "http://tempuri.org/")
        String beginDateTime,
        @WebParam(partName = "endDateTime", name = "endDateTime", targetNamespace = "http://tempuri.org/")
        String endDateTime
    );

    @WebMethod(operationName = "GetIoSources")
    @WebResult(name = "ArrayOfString", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfString getIoSources()
;

    @WebMethod(operationName = "GetEmployeeFullNameFromLoginResult")
    @WebResult(name = "string", targetNamespace = "http://tempuri.org/", partName = "Body")
    public String getEmployeeFullNameFromLoginResult(

        @WebParam(partName = "userName", name = "userName", targetNamespace = "http://tempuri.org/")
        String userName,
        @WebParam(partName = "password", name = "password", targetNamespace = "http://tempuri.org/")
        String password
    );

    @WebMethod(operationName = "GetUiRequestCartableIds")
    @WebResult(name = "UiRequestCartableIds", targetNamespace = "http://tempuri.org/", partName = "Body")
    public UiRequestCartableIds getUiRequestCartableIds(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode
    );

    @WebMethod(operationName = "GetCalendarWorkDayTypesByEmployee")
    @WebResult(name = "ArrayOfCalendarDayListDto", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfCalendarDayListDto getCalendarWorkDayTypesByEmployee(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "fromDate", name = "fromDate", targetNamespace = "http://tempuri.org/")
        String fromDate,
        @WebParam(partName = "toDate", name = "toDate", targetNamespace = "http://tempuri.org/")
        String toDate
    );

    @WebMethod(operationName = "GetAllEmployeesWithOrgId")
    @WebResult(name = "ArrayOfEmployeeInfo", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfEmployeeInfo getAllEmployeesWithOrgId()
;

    @WebMethod(operationName = "GetAllPeriodFunctionalityWinPayList")
    @WebResult(name = "ArrayOfPeriodCalculationInfo", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfPeriodCalculationInfo getAllPeriodFunctionalityWinPayList(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "date", name = "date", targetNamespace = "http://tempuri.org/")
        String date,
        @WebParam(partName = "withVacation", name = "withVacation", targetNamespace = "http://tempuri.org/")
        String withVacation,
        @WebParam(partName = "withSequenceWorkingDetails", name = "withSequenceWorkingDetails", targetNamespace = "http://tempuri.org/")
        String withSequenceWorkingDetails,
        @WebParam(partName = "withSpecialExtraWork", name = "withSpecialExtraWork", targetNamespace = "http://tempuri.org/")
        String withSpecialExtraWork,
        @WebParam(partName = "withVacationRemaining", name = "withVacationRemaining", targetNamespace = "http://tempuri.org/")
        String withVacationRemaining,
        @WebParam(partName = "withSpecialAddSubVacation", name = "withSpecialAddSubVacation", targetNamespace = "http://tempuri.org/")
        String withSpecialAddSubVacation,
        @WebParam(partName = "withMission", name = "withMission", targetNamespace = "http://tempuri.org/")
        String withMission
    );

    @WebMethod(operationName = "GetOrganizationChartList")
    @WebResult(name = "ArrayOfString", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfString getOrganizationChartList(

        @WebParam(partName = "regionId", name = "regionId", targetNamespace = "http://tempuri.org/")
        String regionId
    );

    @WebMethod(operationName = "GetValidCardList")
    @WebResult(name = "ArrayOfString", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfString getValidCardList(

        @WebParam(partName = "regionId", name = "regionId", targetNamespace = "http://tempuri.org/")
        String regionId
    );

    @WebMethod(operationName = "GetAllVacationRegistrationsByDate")
    @WebResult(name = "ArrayOfVacationRegistrationDataModel", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfVacationRegistrationDataModel getAllVacationRegistrationsByDate(

        @WebParam(partName = "date", name = "date", targetNamespace = "http://tempuri.org/")
        String date
    );

    @WebMethod(operationName = "GetAllSubsetOrganizationChartsWithEmployeesByCurrentOrgId")
    @WebResult(name = "ArrayOfOrganizationChartDataModel", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfOrganizationChartDataModel getAllSubsetOrganizationChartsWithEmployeesByCurrentOrgId(

        @WebParam(partName = "currentOrganizationchartId", name = "currentOrganizationchartId", targetNamespace = "http://tempuri.org/")
        String currentOrganizationchartId
    );

    @WebMethod(operationName = "GetAllMissionRegistrationsByDate")
    @WebResult(name = "ArrayOfMissionRegistrationDataModel", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfMissionRegistrationDataModel getAllMissionRegistrationsByDate(

        @WebParam(partName = "date", name = "date", targetNamespace = "http://tempuri.org/")
        String date
    );

    @WebMethod(operationName = "GetIoRecordInDayByEmployeeCode")
    @WebResult(name = "ArrayOfStaffIOs", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfStaffIOs getIoRecordInDayByEmployeeCode(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "DayDate", name = "DayDate", targetNamespace = "http://tempuri.org/")
        String dayDate
    );

    @WebMethod(operationName = "CheckTimeAttendanceSystemHasThirdPartyWebServicec")
    @WebResult(name = "boolean", targetNamespace = "http://tempuri.org/", partName = "Body")
    public boolean checkTimeAttendanceSystemHasThirdPartyWebServicec()
;

    @WebMethod(operationName = "GetAllOrganizationChartList")
    @WebResult(name = "ArrayOfOrganizationChartDataModel", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfOrganizationChartDataModel getAllOrganizationChartList()
;

    @WebMethod(operationName = "GetAllEmployees")
    @WebResult(name = "ArrayOfEmployeeDataModel", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfEmployeeDataModel getAllEmployees()
;

    @WebMethod(operationName = "GetRemainUiEmployeeVacationTypeRepositoryList")
    @WebResult(name = "ArrayOfString", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfString getRemainUiEmployeeVacationTypeRepositoryList(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "CurrentWorkingYear", name = "CurrentWorkingYear", targetNamespace = "http://tempuri.org/")
        String currentWorkingYear
    );

    @WebMethod(operationName = "GetAllSpecialExtraWorksByPeriodId")
    @WebResult(name = "ArrayOfSpecialExtraWorkDataModel", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfSpecialExtraWorkDataModel getAllSpecialExtraWorksByPeriodId(

        @WebParam(partName = "periodId", name = "periodId", targetNamespace = "http://tempuri.org/")
        String periodId
    );

    @WebMethod(operationName = "GetEmployeeCodeByKeyNumber")
    @WebResult(name = "string", targetNamespace = "http://tempuri.org/", partName = "Body")
    public String getEmployeeCodeByKeyNumber(

        @WebParam(partName = "keyNumber", name = "keyNumber", targetNamespace = "http://tempuri.org/")
        String keyNumber,
        @WebParam(partName = "gregorianDate", name = "gregorianDate", targetNamespace = "http://tempuri.org/")
        String gregorianDate,
        @WebParam(partName = "shamsiDate", name = "shamsiDate", targetNamespace = "http://tempuri.org/")
        String shamsiDate,
        @WebParam(partName = "systemType", name = "systemType", targetNamespace = "http://tempuri.org/")
        String systemType,
        @WebParam(partName = "deviceModuleType", name = "deviceModuleType", targetNamespace = "http://tempuri.org/")
        String deviceModuleType
    );

    @WebMethod(operationName = "GetIsExitOverTimeList")
    @WebResult(name = "boolean", targetNamespace = "http://tempuri.org/", partName = "Body")
    public boolean getIsExitOverTimeList(

        @WebParam(partName = "perno", name = "perno", targetNamespace = "http://tempuri.org/")
        String perno,
        @WebParam(partName = "time", name = "time", targetNamespace = "http://tempuri.org/")
        String time,
        @WebParam(partName = "startDate", name = "startDate", targetNamespace = "http://tempuri.org/")
        String startDate,
        @WebParam(partName = "endDate", name = "endDate", targetNamespace = "http://tempuri.org/")
        String endDate
    );

    @WebMethod(operationName = "GetOrganizationChartIdByEmployee")
    @WebResult(name = "long", targetNamespace = "http://tempuri.org/", partName = "Body")
    public long getOrganizationChartIdByEmployee(

        @WebParam(partName = "regionId", name = "regionId", targetNamespace = "http://tempuri.org/")
        String regionId,
        @WebParam(partName = "employeeId", name = "employeeId", targetNamespace = "http://tempuri.org/")
        String employeeId
    );

    @WebMethod(operationName = "GetDayCalculationInfo")
    public void getDayCalculationInfo(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "fromDate", name = "fromDate", targetNamespace = "http://tempuri.org/")
        String fromDate,
        @WebParam(partName = "toDate", name = "toDate", targetNamespace = "http://tempuri.org/")
        String toDate
    );

    @WebMethod(operationName = "GetListOfEmployeeEvents")
    @WebResult(name = "ArrayOfEmployeeDataModel", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfEmployeeDataModel getListOfEmployeeEvents(

        @WebParam(partName = "employeeEvent", name = "employeeEvent", targetNamespace = "http://tempuri.org/")
        String employeeEvent
    );

    @WebMethod(operationName = "AddVacationRegistration")
    @WebResult(name = "string", targetNamespace = "http://tempuri.org/", partName = "Body")
    public String addVacationRegistration(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "vacationId", name = "vacationId", targetNamespace = "http://tempuri.org/")
        String vacationId,
        @WebParam(partName = "beginDateTime", name = "beginDateTime", targetNamespace = "http://tempuri.org/")
        String beginDateTime,
        @WebParam(partName = "endDateTime", name = "endDateTime", targetNamespace = "http://tempuri.org/")
        String endDateTime
    );

    @WebMethod(operationName = "GetAllCurrentlyEmployees")
    @WebResult(name = "ArrayOfEmployeeDataModel", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfEmployeeDataModel getAllCurrentlyEmployees()
;

    @WebMethod(operationName = "GetAllEmployeesOfOneOrganizationChartWithAllSubsets")
    @WebResult(name = "ArrayOfEmployeeDataModel", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfEmployeeDataModel getAllEmployeesOfOneOrganizationChartWithAllSubsets(

        @WebParam(partName = "currentOrganizationchartId", name = "currentOrganizationchartId", targetNamespace = "http://tempuri.org/")
        String currentOrganizationchartId
    );

    @WebMethod(operationName = "GetIORecordAfterId")
    @WebResult(name = "ArrayOfIoRecordDataModel", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfIoRecordDataModel getIORecordAfterId(

        @WebParam(partName = "id", name = "id", targetNamespace = "http://tempuri.org/")
        String id
    );

    @WebMethod(operationName = "IsPresent")
    @WebResult(name = "boolean", targetNamespace = "http://tempuri.org/", partName = "Body")
    public boolean isPresent(

        @WebParam(partName = "id", name = "id", targetNamespace = "http://tempuri.org/")
        String id,
        @WebParam(partName = "dateTime", name = "dateTime", targetNamespace = "http://tempuri.org/")
        String dateTime
    );

    @WebMethod(operationName = "GetDevicePersons")
    @WebResult(name = "ArrayOfDevicePerson", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfDevicePerson getDevicePersons(

        @WebParam(partName = "deviceModuleType", name = "deviceModuleType", targetNamespace = "http://tempuri.org/")
        String deviceModuleType
    );

    @WebMethod(operationName = "GetAllIoRecordsByDate")
    @WebResult(name = "ArrayOfIoRecordDataModel", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfIoRecordDataModel getAllIoRecordsByDate(

        @WebParam(partName = "date", name = "date", targetNamespace = "http://tempuri.org/")
        String date
    );

    @WebMethod(operationName = "GetUiRequestCartableCount")
    @WebResult(name = "string", targetNamespace = "http://tempuri.org/", partName = "Body")
    public String getUiRequestCartableCount(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode
    );

    @WebMethod(operationName = "GetRemainUiEmployeeVacationTypeRepository")
    @WebResult(name = "string", targetNamespace = "http://tempuri.org/", partName = "Body")
    public String getRemainUiEmployeeVacationTypeRepository(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "vacationtypeId", name = "vacationtypeId", targetNamespace = "http://tempuri.org/")
        String vacationtypeId
    );

    @WebMethod(operationName = "GetAllValidEmployeeRange")
    @WebResult(name = "ArrayOfValidEmployeeRange", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfValidEmployeeRange getAllValidEmployeeRange(

        @WebParam(partName = "dateTime", name = "dateTime", targetNamespace = "http://tempuri.org/")
        String dateTime,
        @WebParam(partName = "requestState", name = "requestState", targetNamespace = "http://tempuri.org/")
        String requestState
    );

    @WebMethod(operationName = "GetIORecordPerDateRange")
    @WebResult(name = "ArrayOfIoRecordDataModel", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfIoRecordDataModel getIORecordPerDateRange(

        @WebParam(partName = "fromDate", name = "fromDate", targetNamespace = "http://tempuri.org/")
        String fromDate,
        @WebParam(partName = "toDate", name = "toDate", targetNamespace = "http://tempuri.org/")
        String toDate
    );

    @WebMethod(operationName = "GetCalendarWorkDayTypes")
    @WebResult(name = "ArrayOfCalendarDayListDto", targetNamespace = "http://tempuri.org/", partName = "Body")
    public ArrayOfCalendarDayListDto getCalendarWorkDayTypes(

        @WebParam(partName = "calendarName", name = "calendarName", targetNamespace = "http://tempuri.org/")
        String calendarName,
        @WebParam(partName = "fromDate", name = "fromDate", targetNamespace = "http://tempuri.org/")
        String fromDate,
        @WebParam(partName = "toDate", name = "toDate", targetNamespace = "http://tempuri.org/")
        String toDate
    );

    @WebMethod(operationName = "AddMissionRegistrationEx")
    @WebResult(name = "string", targetNamespace = "http://tempuri.org/", partName = "Body")
    public String addMissionRegistrationEx(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "confirmEmployeeCode", name = "confirmEmployeeCode", targetNamespace = "http://tempuri.org/")
        String confirmEmployeeCode,
        @WebParam(partName = "missionId", name = "missionId", targetNamespace = "http://tempuri.org/")
        String missionId,
        @WebParam(partName = "beginDateTime", name = "beginDateTime", targetNamespace = "http://tempuri.org/")
        String beginDateTime,
        @WebParam(partName = "endDateTime", name = "endDateTime", targetNamespace = "http://tempuri.org/")
        String endDateTime,
        @WebParam(partName = "missionLocationName", name = "missionLocationName", targetNamespace = "http://tempuri.org/")
        String missionLocationName
    );

    @WebMethod(operationName = "AddVacationRegistrationPermission")
    @WebResult(name = "string", targetNamespace = "http://tempuri.org/", partName = "Body")
    public String addVacationRegistrationPermission(

        @WebParam(partName = "employeeCode", name = "employeeCode", targetNamespace = "http://tempuri.org/")
        String employeeCode,
        @WebParam(partName = "vacationId", name = "vacationId", targetNamespace = "http://tempuri.org/")
        String vacationId,
        @WebParam(partName = "beginDateTime", name = "beginDateTime", targetNamespace = "http://tempuri.org/")
        String beginDateTime,
        @WebParam(partName = "endDateTime", name = "endDateTime", targetNamespace = "http://tempuri.org/")
        String endDateTime,
        @WebParam(partName = "vacationRequestReason", name = "vacationRequestReason", targetNamespace = "http://tempuri.org/")
        String vacationRequestReason,
        @WebParam(partName = "description", name = "description", targetNamespace = "http://tempuri.org/")
        String description
    );

    @WebMethod(operationName = "PersistIoRecrd")
    @WebResult(name = "boolean", targetNamespace = "http://tempuri.org/", partName = "Body")
    public boolean persistIoRecrd(

        @WebParam(partName = "keyNumber", name = "keyNumber", targetNamespace = "http://tempuri.org/")
        String keyNumber,
        @WebParam(partName = "ioDateTime", name = "ioDateTime", targetNamespace = "http://tempuri.org/")
        String ioDateTime,
        @WebParam(partName = "deviceModuleType", name = "deviceModuleType", targetNamespace = "http://tempuri.org/")
        String deviceModuleType,
        @WebParam(partName = "hadwareCode", name = "hadwareCode", targetNamespace = "http://tempuri.org/")
        String hadwareCode
    );
}
