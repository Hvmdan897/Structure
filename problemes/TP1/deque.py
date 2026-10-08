
class Deque:
    def __init__(self):
        self.items = []

    def push_front(self, x):
        self.items.insert(0, x)

    def push_back(self, x):
        self.items.append(x)

    def pop_front(self):
        return self.items.pop(0)

    def pop_back(self):
        return self.items.pop()

    def is_empty(self):
        return len(self.items) == 0

    def __len__(self):
        return len(self.items)


if __name__ == "__main__":
    d = Deque()
    d.push_back(1)
    d.push_back(2)
    d.push_front(0)
    print(d.pop_front())
    print(d.pop_back())
    print(len(d))