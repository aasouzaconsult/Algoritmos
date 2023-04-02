# Group Anagrams
# input = ["star, astr, car, rac, st"]
# output = [["star, astr"],["car","rac"],["st"]);


def group_anagrams(a_list):

    new_list = []

    for item in a_list:
        for it in item.split(", "):
            new_list.append(it)

    list_of_dicts = [dict()] * len(new_list)
    print list_of_dicts
    for i in range(len(new_list)):
        for char in new_list[i]:            
            if char not in list_of_dicts[i].keys():
                list_of_dicts[i][char] = 1
            else:
                list_of_dicts[i][char] += 1

    print list_of_dicts

if __name__ == "__main__":
    new_input = ["star, astr, car, rac, st"]
    group_anagrams(new_input)
