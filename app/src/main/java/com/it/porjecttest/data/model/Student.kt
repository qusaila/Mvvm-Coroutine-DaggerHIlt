package com.it.porjecttest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

class Student : StatusResponse(), Serializable {
    @SerializedName("IsIndividual")
    @Expose
    var isConsumer = false
        private set
    var isHasCompetition = false
    var isHasAvailableCompetition = false
    var isCurrentStudent = false
    var imagePath = ""
    var isMuteMode = false
    var creationDate: String? = null
    var isFirstLogin = false

     var completedStories = 0
    var isLeaderboardEnabled = false


    var profileImagePath = ""

    var userName: String? = null


    var studentID = 0
    var position = 0
    var studentName: String? = null

    @SerializedName("Email")
    @Expose
    var email: String? = null

    @SerializedName("StudentAssessmentID")
    @Expose
    var studentAssessmentID = 0

    @SerializedName("IsSubscribed")
    @Expose
    var isSubscribed = false

    @SerializedName("HasAssessment")
    @Expose
    var isHasAssessment = false

    @SerializedName("GradeID")
    @Expose
    var gradeID = 0

    @SerializedName("AgeID")
    @Expose
    var ageID = 0

    @SerializedName("AccountID")
    @Expose
    var accountID = 0

    @SerializedName("Grade")
    @Expose
    var grade: String? = null

    @SerializedName("ReadingLevelID")
    @Expose
    var readingLevelID = 0

    @SerializedName("KnowledgePower")
    @Expose
    var knowledgePower = 0

    @SerializedName("IsActive")
    @Expose
    var isActive = false

    @SerializedName("AvatarID")
    @Expose
    var avatarID = 0

    @SerializedName("HasAssignment")
    @Expose
    var isHasAssignment = false

    @SerializedName("CompletedBooks")
    @Expose
    var completedBooks = 0

    @SerializedName("ReadingLevel")
    @Expose
    var readingLevel = ""

    @SerializedName("Coins")
    @Expose
    var coins = 0
        get() = if (field < 0) 0 else field

    @SerializedName("FirstName")
    @Expose
    var firstName: String? = null
        get() {
            if (field == null) field = ""
            return field
        }

    @SerializedName("IsParentInfoFilled")
    @Expose
    var isParentInfoFilled = false

    fun setIndividual(individual: Boolean) {
        isConsumer = individual
    }

}