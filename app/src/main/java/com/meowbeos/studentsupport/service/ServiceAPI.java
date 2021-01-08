package com.meowbeos.studentsupport.service;

import io.reactivex.Observable;

import com.meowbeos.studentsupport.model.BusStop;
import com.meowbeos.studentsupport.model.CollectNews;
import com.meowbeos.studentsupport.model.Competition;
import com.meowbeos.studentsupport.model.DetailGroupSubjects;
import com.meowbeos.studentsupport.model.DetailNews;
import com.meowbeos.studentsupport.model.Document;
import com.meowbeos.studentsupport.model.EnrollClass;
import com.meowbeos.studentsupport.model.FieldsRegister;
import com.meowbeos.studentsupport.model.FileDocument;
import com.meowbeos.studentsupport.model.GeneralNews;
import com.meowbeos.studentsupport.model.GroupSubjects;
import com.meowbeos.studentsupport.model.RequestObject;
import com.meowbeos.studentsupport.model.ResponseObject;
import com.meowbeos.studentsupport.model.RouteBus;
import com.meowbeos.studentsupport.model.Schedule;
import com.meowbeos.studentsupport.model.Semester;
import com.meowbeos.studentsupport.model.Student;
import com.meowbeos.studentsupport.model.Subjects;
import com.meowbeos.studentsupport.model.WeeklySchedule;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public interface ServiceAPI {

    //region 0/Account
    @POST("loginaccount")
    Observable<ResponseObject> postLoginAccount(
            @Body RequestObject loginAccount
    );

    @POST("changepassaccount")
    Observable<ResponseObject> postChangePassAccount(
            @Body RequestObject changePassAccount
    );
    //endregion

    //region 1/ NEWS
    @GET("listnews")
    Observable<CollectNews> getListNews(
            @Query("apikey") String apiKey
    );

    @GET("listnewsbycategory")
    Observable<GeneralNews> listNewsByCategory(
            @Query("apikey") String apiKey,
            @Query("rowcollect") String rowCollect
    );

    @GET("detailnews")
    Observable<DetailNews> detailNews(
            @Query("apikey") String apiKey,
            @Query("idnews") String idNews
    );
    //endregion

    //region 2/ SCHEDULE
    @GET("listschedule")
    Observable<WeeklySchedule> getListSchedule(
            @Query("apikey") String apiKey,
            @Query("idstudent") String idStudent,
            @Query("daterequest") String dateRequest
    );

    @GET("detailschedule")
    Observable<Schedule> detaiSchedule(
            @Query("apikey") String apiKey,
            @Query("idschedule") String idSchedule
    );
    //endregion

    //region 3/ COMPETITION
    @GET("listcompetition")
    Observable<List<Competition>> getListCompetition(
            @Query("apikey") String apiKey
    );

    @GET("detailcompetition")
    Observable<Competition> detailCompetition(
            @Query("apikey") String apiKey,
            @Query("idcompetition") String idCompetition
    );

    @GET("listfieldsregister")
    Observable<List<FieldsRegister>> getListFieldsRegister(
            @Query("apikey") String apiKey,
            @Query("idcompetition") String idCompetition
    );

    @POST("registercompetition")
    Observable<ResponseObject> postRegisterCompetition(
            @Body RequestObject registerCompetition
    );
    //endregion

    //region 4/ DOCUMENT
    @GET("listdocumentcategory")
    Observable<List<Document>> getListDocumentCategory(
            @Query("apikey") String apiKey
    );

    @GET("listdocumentfile")
    Observable<List<Document>> getListDocumentFile(
            @Query("apikey") String apiKey,
            @Query("iddocument") String idDocument
    );

    @GET("listfile")
    Observable<List<FileDocument>> getListFile(
            @Query("apikey") String apiKey,
            @Query("iddocument") String idDocument
    );
    //endregion

    // region 5/ GROUPSUBJECTS
    @GET("listgroupsubjects")
    Observable<List<GroupSubjects>> getListGroupSubjects(
            @Query("apikey") String apiKey,
            @Query("idstudent") String idStudent
    );

    @GET("detailgroupsubjects")
    Observable<DetailGroupSubjects> detailGroupSubjects(
            @Query("apikey") String apiKey,
            @Query("idgroupsubjects") String idGroupSubjects
    );

    @GET("liststudentgroup")
    Observable<List<Student>> getListStudentGroup(
            @Query("apikey") String apiKey,
            @Query("idgroupsubjects") String idGroupSubjects
    );
    //endregion

    // region 6/ MARKS
    @GET("listsemester")
    Observable<List<Semester>> getListSemester(
            @Query("apikey") String apiKey,
            @Query("idstudent") String idStudent
    );

    @GET("listsubjects")
    Observable<List<Subjects>> getListSubjects(
            @Query("apikey") String apiKey,
            @Query("idsemester") String idSemester
    );

    @POST("calculatemarks")
    Observable<ResponseObject> postCalculateMarks(
            @Body RequestObject calculateMarks
    );
    //endregion

    // region 7/ FOLLOWBUS
    @GET("listbusstop")
    Observable<List<BusStop>> getListBusStop(
            @Query("lng1") String lng1,
            @Query("lat1") String lat1,
            @Query("lng2") String lng2,
            @Query("lat2") String lat2
    );

    @GET("listnextbus")
    Observable<List<RouteBus>> getListNextBus(
            @Query("bustopid") String bustopid
    );
    //endregion

    // region 8/ ENROLLCLASS
    @GET("listenrollclass")
    Observable<List<EnrollClass>> getListEnrollClass(
            @Query("apikey") String apiKey,
            @Query("idstudent") String idStudent
    );

    @GET("listsubjectsenroll")
    Observable<List<Subjects>> getListSubjectsEnroll(
            @Query("apikey") String apiKey,
            @Query("idstudent") String idStudent
    );

    @POST("enrollcancel")
    Observable<ResponseObject> postEnrollCancel(
            @Body RequestObject enrollCancel
    );
    //endregion
}
