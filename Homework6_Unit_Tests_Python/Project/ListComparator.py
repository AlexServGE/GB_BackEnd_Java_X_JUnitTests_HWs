class ListComparator:

    @staticmethod
    def calc_list_average(list):
        if len(list) == 0:
            raise ZeroDivisionError("List cannot be empty")
        return sum(list) / len(list)

    @staticmethod
    def compare_lists_average(list1, list2):
        list1_average = ListComparator.calc_list_average(list1)
        list2_average = ListComparator.calc_list_average(list2)
        if list1_average > list2_average:
            return "Первый список имеет большее среднее значение"
        elif list1_average < list2_average:
            return "Второй список имеет большее среднее значение"
        else:
            return "Средние значения равны"
