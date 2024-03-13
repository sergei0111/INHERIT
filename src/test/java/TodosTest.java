import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "query");

        String[] subtasks = {"Молоко", "Яйца", "query"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "query",
                "query",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("query");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQuery_2() {
        SimpleTask simpleTask = new SimpleTask(0, "0");

        String[] subtasks = {"0", "0", "0"};
        Epic epic = new Epic(0, subtasks);

        Meeting meeting = new Meeting(
                0,
                "0",
                "0",
                "0"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Object o = "0";

        boolean expected = false;
        boolean actual = equals(o);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addToArray() {
        SimpleTask simpleTask = new SimpleTask(5, "query");

        String[] subtasks = {"Молоко", "Яйца", "Шоколад"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting1 = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "query",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting1);
        Task meeting = new Meeting(557, "New", "query", "monday");
        todos.add(meeting);


        Task[] expected = {simpleTask, epic, meeting1, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetId() {
        Task task = new Task(55);

        int expected = task.id;
        int actual = task.getId();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void searchQueryOnlyNull() {
        SimpleTask simpleTask = new SimpleTask(10, "Простая Задача");

        String[] subtasks = {"Молоко", "Яйца", "Шоколад"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                100,
                "Наше приложение",
                "Добавление новой фичи",
                "01.04.2024"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Верификация");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchForQuery() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(9, "Подписать договор"));
        todos.add(new Epic(5, new String[]{"Отправить СМС"}));

        Task[] expected = {new Epic(5, new String[]{"Отправить СМС"})};
        Task[] actual = todos.search("СМС");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetters_1() {
        Epic epic = new Epic(55, new String[]{"Купить молоток"});

        String[] expected = {"Купить молоток"};
        String[] actual = epic.getSubtasks();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testGetters_2() {
        Meeting meeting = new Meeting(
                100,
                "Наше приложение",
                "Добавление новой фичи",
                "01.04.2024"
        );

        String[] expected = {"Наше приложение"};
        String[] actual = new String[]{meeting.getTopic()};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testGetters_3() {
        Meeting meeting = new Meeting(
                100,
                "Наше приложение",
                "Добавление новой фичи",
                "01.04.2024"
        );

        String[] expected = {"Добавление новой фичи"};
        String[] actual = new String[]{meeting.getProject()};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testGetters_4() {
        Meeting meeting = new Meeting(
                100,
                "Наше приложение",
                "Добавление новой фичи",
                "01.04.2024"
        );

        String[] expected = {"01.04.2024"};
        String[] actual = new String[]{meeting.getStart()};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testGetters_5() {
        SimpleTask simpleTask = new SimpleTask(10, "Составть график отпусков отдела");

        String[] expected = {"Составть график отпусков отдела"};
        String[] actual = new String[]{simpleTask.getTitle()};

        Assertions.assertArrayEquals(expected, actual);

    }

}