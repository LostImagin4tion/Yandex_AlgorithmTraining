# Динамическое программирование с одним параметром

## Задачи

### [Три единицы подряд](https://github.com/LostImagin4tion/Yandex_AlgorithmTraining/blob/master/src/main/kotlin/dpOneParameter/ThreeUnitsInRow.kt)

По данному числу N определите количество последовательностей из нулей и единиц длины N, в которых никакие три единицы не стоят рядом.

### [Кузнечик](https://github.com/LostImagin4tion/Yandex_AlgorithmTraining/blob/master/src/main/kotlin/dpOneParameter/Grasshopper.kt)

У одного из студентов в комнате живёт кузнечик, который очень любит прыгать по клетчатой одномерной доске. Длина доски — N клеток. К его сожалению, он умеет прыгать только на 1, 2, …, k клеток вперёд.

Однажды студентам стало интересно, сколькими способами кузнечик может допрыгать из первой клетки до последней. Помогите им ответить на этот вопрос.

### [Калькулятор](https://github.com/LostImagin4tion/Yandex_AlgorithmTraining/blob/master/src/main/kotlin/dpOneParameter/Calculator.kt)

Имеется калькулятор, который выполняет следующие операции:

- умножить число X на 2;
- умножить число X на 3;
- прибавить к числу X единицу.
Определите, какое наименьшее количество операций требуется, чтобы получить из числа 1 число N.

### [Покупка билетов](https://github.com/LostImagin4tion/Yandex_AlgorithmTraining/blob/master/src/main/kotlin/dpOneParameter/BuyingTickets.kt)

За билетами на премьеру нового мюзикла выстроилась очередь из N человек, каждый из которых хочет купить 1 билет. На всю очередь работала только одна касса, поэтому продажа билетов шла очень медленно, приводя «постояльцев» очереди в отчаяние. Самые сообразительные быстро заметили, что, как правило, несколько билетов в одни руки кассир продаёт быстрее, чем когда эти же билеты продаются по одному. Поэтому они предложили нескольким подряд стоящим людям отдавать деньги первому из них, чтобы он купил билеты на всех.

Однако для борьбы со спекулянтами кассир продавала не более 3-х билетов в одни руки, поэтому договориться таким образом между собой могли лишь 2 или 3 подряд стоящих человека.

Известно, что на продажу i-му человеку из очереди одного билета кассир тратит Ai секунд, на продажу двух билетов — Bi секунд, трех билетов — Ci секунд. Напишите программу, которая подсчитает минимальное время, за которое могли быть обслужены все покупатели.

Обратите внимание, что билеты на группу объединившихся людей всегда покупает первый из них. Также никто в целях ускорения не покупает лишних билетов (то есть билетов, которые никому не нужны).

### [Гвоздики](https://github.com/LostImagin4tion/Yandex_AlgorithmTraining/blob/master/src/main/kotlin/dpOneParameter/Nails.kt)

В дощечке в один ряд вбиты гвоздики. Любые два гвоздика можно соединить ниточкой. Требуется соединить некоторые пары гвоздиков ниточками так, чтобы к каждому гвоздику была привязана хотя бы одна ниточка, а суммарная длина всех ниточек была минимальна.
