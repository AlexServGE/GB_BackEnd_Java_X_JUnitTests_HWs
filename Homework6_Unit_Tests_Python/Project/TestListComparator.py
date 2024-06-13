from parameterized import parameterized
import pytest
import unittest

from ListComparator import ListComparator


class TestListComparator(unittest.TestCase):

    listComparator = ListComparator

    def test_calc_list_average(self):
        list = [1, 2, 3]

        expected_average = 2

        self.assertEqual(self.listComparator.calc_list_average(list), expected_average)

    def test_calc_list_average_empty_list(self):
        empty_list = []

        with pytest.raises(ZeroDivisionError):
            self.listComparator.calc_list_average(empty_list)

    @parameterized.expand([
        [[1, 2, 3, 4, 5], [1, 2, 3, 4, 5],
         "Средние значения равны"],
        [[5, 2, 3, 4, 5], [1, 2, 3, 4, 5],
         "Первый список имеет большее среднее значение"],
        [[1, 2, 3, 4, 5], [5, 2, 3, 4, 5],
         "Второй список имеет большее среднее значение"],
    ])
    def test_compare_lists_average(self, list1, list2, expected):
        self.assertEqual(self.listComparator.compare_lists_average(list1, list2), expected)

    def test_compare_lists_average_empty_list(self):
        list1 = []
        empty_list2 = []

        with pytest.raises(ZeroDivisionError):
            self.listComparator.compare_lists_average(list1, empty_list2)
