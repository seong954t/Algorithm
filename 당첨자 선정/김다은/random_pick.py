import random

people_list = ["김기환", "김다은", "김미지", "김수연", "김승태", "김진혁", "나재성", "신승혁", "장은정", "최소영"]
prev_list = ["김다은", "김승태", "김수연", "김진혁", "최소영"]
pick_num = 2
pick_list = []

while len(pick_list) < pick_num:
    random_pick = random.choice(people_list)
    if random_pick not in (prev_list + pick_list):
        pick_list.append(random_pick)

print(pick_list)