$(document).ready(function() {
    var questionNumber = 0;
    var userAnswers = [];
    var sumCorrectAnswers = 0;

    function updateQuestionNumber() {
        $('#question-number').text( 'Вопрос №' + (questionNumber + 1) + '/' +  (+$('.question-length').val() + 1) );
    }

    $('input[name=radio-question]').change(function () {
        $(this).parents('.question' + questionNumber).find('.ans-button').prop('disabled', false);
    });

    $('.ans-button').click(function () {
        var ansId = $('input[name=radio-question]:checked').val();
        userAnswers.push(ansId);

        checkAnswer(ansId, this);
    });

    function checkAnswer(ansId, button) {
        $.ajax({
            url: "/checkAnswer",
            method: 'POST',
            data: {
                answerId: ansId
            }
        }).done(function(response) {
            if(response) {
                sumCorrectAnswers++;
                nextQuestion();
            }else{
                $(button).parents('.question' + questionNumber).find('.wrong-ans-text').removeClass('hidden');
                $(button).parents('.question' + questionNumber).find('.ans-button').addClass('hidden');
                $(button).parents('.question' + questionNumber).find('.wrong-ans-button').removeClass('hidden');
            }
        });
    }

    $('.wrong-ans-button').click(function () {
        nextQuestion();
    });

    function nextQuestion() {
        $('.question' + questionNumber).remove();

        if(questionNumber == (+$('.question-length').val())) {
            finishTest();
        }else{
            questionNumber++;
            $('.question' + questionNumber).removeClass('hidden');
            updateQuestionNumber();
        }
    }

    function finishTest() {
        $('.donut-panel').removeClass('hidden');
        showChart(Math.round((sumCorrectAnswers/(questionNumber + 1)) * 100));

        $('#question-number').remove();

        if($('.testType').val() == 0) {
            $('.finish-text').text('Тест завершен!');
        }else{
            if((questionNumber + 1) - sumCorrectAnswers <= 2) {
                $('.finish-text').text('Тест успешно пройден!');
            }else{
                $('.finish-text').text('Тест не пройден!');
            }
        }

        sendAnswers();
    }

    function showChart(writePercent) {
        Morris.Donut({
            element: 'hero-donut',
            data: [
                {label: 'Правильно', value: writePercent},
                {label: 'Не правильно', value: 100 - writePercent}
            ],
            colors: ['#228B22', '#FF0000'],
            formatter: function (y) { return y + "%" }
        });
        $('.code-example').each(function (index, el) {
            eval($(el).text());
        });
    }

    function sendAnswers() {
        $.ajax({
            url: "/setUserAnswers",
            method: 'POST',
            data: {
                userAnswers: JSON.stringify(userAnswers),
                testType: $('.testType').val(),
                testId: $('.testId').val()
            }
        }).done(function(response) {

        });
    }

    $('.question' + questionNumber).removeClass('hidden');
    updateQuestionNumber();
});