package com.example.onlinequiz.utils

import android.content.Context
import android.util.Log
import android.widget.TextView
import com.example.onlinequiz.models.QuizQuestion
import com.example.onlinequiz.models.QuizResponse
import com.example.onlinequiz.retrofit.QuizService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

class QuizClass(private val context: Context) {

    fun getQuizList(amount:Int, category:Int?, difficulty:String?, type:String?,tv1:TextView,tv2:TextView ){
           if (Constants.isNetworkAvailable(context))
           {
               val retrofit :Retrofit=Retrofit.Builder()
                   .baseUrl("https://opentdb.com/")
                   .addConverterFactory(GsonConverterFactory.create()).build()
               val service:QuizService = retrofit.create(QuizService::class.java)
               val dataCall: Call<QuizResponse> = service.getQuiz(amount, category, difficulty, type)
               dataCall.enqueue(object :Callback<QuizResponse>{
                   override fun onResponse(
                       call: Call<QuizResponse>,
                       response: Response<QuizResponse>
                   ) {
                       if (response.isSuccessful){
                           val responseData:QuizResponse=response.body()!!
                           val questionList=responseData.results
                           tv1.text=questionList.toString()
                           tv2.text=questionList.size.toString()
                           Log.e("debug",questionList.toString())
                       }
                       else
                       {
                           Utils.showToast(context,"failed ")
                       }
                   }

                   override fun onFailure(call: Call<QuizResponse>, t: Throwable) {
                       Utils.showToast(context,"failed ")
                   }

               })

           }
        else
               Utils.showToast(context,"network failed  ")

    }
}