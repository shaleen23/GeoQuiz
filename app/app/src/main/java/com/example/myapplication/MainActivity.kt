import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //private lateinit var prevButton: Button
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var quizQuestion: TextView
    private lateinit var txtCorrect: TextView
    private lateinit var txtIncorrect: TextView
    /*
    private val questionBank = listOf(
        Question(R.string.question_australia, true)
                Question(R.string.question_oceans, true)
    Question(R.string.question_mideast, false)
    Question(R.string.question_africa, false)
    Question(R.string.question_americas, true)
    Question(R.string.question_asia, true))
    */


    // Counters

    private var cntCorrect = 0
    private var cntIncorrect = 0
    var current: Int = Random.nextInt(0, 5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quizQuestion = findViewById(R.id.quizQuestion)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        txtCorrect = findViewById(R.id.txtCorrect)
        txtIncorrect = findViewById(R.id.txtIncorrect)


        current = Random.nextInt(0, 5)

        val questions = arrayOf(
            Question(R.string.question_australia, false),
            Question(R.string.question_river, false),
            Question(R.string.question_americaRiver, true),
            Question(R.string.question_lake, false),
            Question(R.string.question_oceans, true),
            Question(R.string.question_canal, true)
        )

        quizQuestion.text = getString(questions[current].questionTextId)
        txtCorrect.text = getString(R.string.correct_count_label, cntCorrect)
        txtIncorrect.text = getString(R.string.incorrect_count_label, cntIncorrect)

        trueButton.setOnClickListener {
            checkAnswer(questions[current])
        }

        falseButton.setOnClickListener {
            checkAnswer(questions[current])
        }
    }
/*
trueButton = findViewById(R.id.true_button)
falseButton = findViewById(R.id.false_button)
nextButton = findViewbyId(R.id.next_button)
questionTextView = findViewbyId(R.id.question_text_view)

trueButton.setOnClickListener { view: View ->
    Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show()
    checkAnswer(true)
}

falseButton.setOnClickListener { view: View ->
    // Do something in response to the click here
    Toast.makeText(
        this,
        R.string.incorrect_toast,
        Toast.LENGTH_SHORT)
        .show()
    checkAnswer(false)
}

val questionTextResId = questionBank[currentIndex].textResId
questionTextView,setText(questionTextResId)

nextButton.setOnClickListener {
    currentIndex = (currentIndex + 1) % questionBank.size
    val questionTextResId = questionBank[currentIndex].textResId
    questionTextView.setText(questionTextResId)

    updateQuestion()
}
val questionTextResId = questionBank[currentIndex].textResId
questionTextView.setText(questionTextResId)

updateQuestion()

}

private fun updateQuestion() {
val questionTextResId = questionBank[current].textResId
questionTextView.setText(questionTextResId)
}
 */

    private fun checkAnswer(question: Question) {
        if (question.answer.toString() == "true") {
            cntCorrect++
            txtCorrect.text = getString(R.string.correct_count_label, cntCorrect)
            current = Random.nextInt(0, 5)
            quizQuestion.text = getString(question.questionTextId)
        } else {
            cntIncorrect++
            txtIncorrect.text = getString(R.string.incorrect_count_label, cntIncorrect)
            current = Random.nextInt(0, 5)
            quizQuestion.text = getString(question.questionTextId)
        }
    }
}
