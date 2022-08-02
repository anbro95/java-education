package com.knubisoft.base.list;

import java.util.*;
import java.util.stream.Collectors;

public class ListTasksImpl implements ListTasks {
    @Override
    public List<String> addElements(String... elements) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            res.add(elements[i]);
        }
        return res;
    }  //

    @Override
    public List<String> getElementsByIndexes(List<String> elements, int[] indexes) {
        if(indexes == null)
            throw new IllegalArgumentException();

        for (int i = 0; i < indexes.length; i++) {
            if(indexes[i] > elements.size() || indexes[i] < elements.size())
                throw new IllegalArgumentException();

            elements.add(elements.get(indexes[i]));
        }
        return elements;
    }  //

    @Override
    public ArrayList<String> addElementsByIndexes(ArrayList<String> elements, int[] indexes) {
        return null;
    }

    @Override
    public LinkedList<String> setElementsByIndexes(LinkedList<String> elements, int[] indexes) {
        return elements;
    }

    @Override
    public int getListSize(List<String> list) {
        if(list == null)
            return 0;
        else
            return list.size();
    }  //

    @Override
    public List<Long> merge(List<Integer> first, List<Long> second, List<String> third) {
        if(first == null || second == null || third == null)
            throw new NullPointerException();
        List<Long> res = new ArrayList<>();
        try{
            for (int i = 0; i < first.size(); i++) {
                    res.add(i, Long.parseLong(String.valueOf(first.get(i))));
            }

            for (int i = 0; i < second.size(); i++) {
                res.add(i + first.size() - 1, Long.parseLong(String.valueOf(second.get(i))));
            }

            for (int i = 0; i < third.size(); i++) {
                res.add(i + first.size() + second.size() - 1, Long.parseLong(third.get(i)));
            }
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }

        return res;
    }

    @Override
    public int findMaxValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        if(first == null || second == null || third == null)
            throw new RuntimeException();

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int res = 0;
        for (Integer value : first) {
            if (value > max1) {
                max1 = value;
                res = max1;
            }
        }

        for (Integer integer : second) {
            if (integer > max2)
                max2 = integer;
            if(max2 > res)
                res = max2;
        }

        for (Integer integer : third) {
            if (integer > max3)
                max3 = integer;
            if(max3 > res)
                res = max3;
        }

        return res;
    }  //

    @Override
    public int findMinValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        if(first == null || second == null || third == null)
            throw new RuntimeException();

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int res = 0;
        for (Integer value : first) {
            if (value < min1) {
                min1 = value;
                res = min1;
            }
        }

        for (Integer integer : second) {
            if (integer < min2)
                min2 = integer;
            if(min2 < res)
                res = min2;
        }

        for (Integer integer : third) {
            if (integer < min3)
                min3 = integer;
            if(min3 < res)
                res = min3;
        }

        return res;
    }  //

    @Override
    public int multiplyMax2Elements(List<Integer> first, List<Integer> second, List<Integer> third) {
        if(first == null || second == null || third == null)
            throw new RuntimeException();

        List<Long> secint = new ArrayList<>();
        List<String> thirdint = new ArrayList<>();
        for(Integer i : second) {
            secint.add(Long.valueOf(i));
        }
        for(Integer i : third) {
            thirdint.add(String.valueOf(i));
        }

        List<Long> list = (merge(first, secint, thirdint));
        Collections.sort(list);

        return (int) (list.get(list.size()-1) * list.get(list.size()-2));
    }  //

    @Override
    public List<String> removeNulls(List<String> list) {
        if(list == null)
            throw new RuntimeException();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == null) {
                list.remove(i);
            }
        }

        return list;
    }  //

    @Override
    public List<Integer> flatMapWithoutNulls(List<List<Integer>> list) {
//        List<List<Integer>> clone = list.stream().map(inner -> inner.stream().filter(item -> null != item)).collect(Collectors.toList()).stream().collect(Collectors.toList());

        return new ArrayList<Integer>();

    }

    @Override
    public List<Integer> cloneIds(List<Integer> originalIds) {
        if (originalIds == null)
            throw new NoSuchElementException();

        List<Integer> clone = new ArrayList<>();

        for (int i = 0; i < originalIds.size(); i++) {
            if(originalIds.get(i) == null) {
                continue;
            }
            clone.add(originalIds.get(i));
        }

        return clone;
    }  //

    @Override
    public List<String> shuffle(List<String> originalStrings) {
        List<String> res = new ArrayList<>();
        List<Integer> randoms = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        Random rand = new Random();
        for (int i = 0; i < originalStrings.size(); i++) {
            int a = rand.nextInt(originalStrings.size()-1);
            randoms.add(a);
        }

        for (int i = 0; i < originalStrings.size(); i++) {
            res.add(randoms.get(i), originalStrings.get(i));
        }
        return res;
    }

    @Override
    public String getLastElement(LinkedList<String> list) {
        if(list == null) {
            throw new NoSuchElementException();
        } else if(list.isEmpty()) {
            return "";
        }
        return list.get(list.size()-1);
    }  // 

    @Override
    public List<String> compareElements(LinkedList<String> originalCollection, LinkedList<String> additionalCollection) {
        if(originalCollection == null || additionalCollection == null) {
            throw new IllegalArgumentException();
        } else if(originalCollection.isEmpty() || additionalCollection.isEmpty()) {
            return Collections.emptyList();
        }


        List<String> res = new ArrayList<>();
        for (int i = 0; i < originalCollection.size(); i++) {
            for (int j = 0; j < additionalCollection.size(); j++) {
                if(originalCollection.get(i).equals(additionalCollection.get(j))){
                    res.add(originalCollection.get(i));
                }
            }
        }

        return res;
    }  //
}
