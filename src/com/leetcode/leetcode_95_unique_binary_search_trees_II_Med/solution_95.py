# coding:utf-8


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def generateTrees(self, n: int) -> [TreeNode]:
        def node(v, l, r):
            t = TreeNode(v)
            t.left = l
            t.right = r
            return t

        def helper_deprecated(low, high):
            if low > high:
                return [None]
            if low == high:
                return [node(low, None, None)]
            nodes = []
            for root in range(low, high + 1):
                for l_child in helper(low, root - 1):
                    for r_child in helper(root + 1, high):
                        nodes.append(node(root, l_child, r_child))
            return nodes

        def helper(low, high):
            nodes = []
            for root in range(low, high + 1):
                for l_child in helper(low, root - 1):
                    for r_child in helper(root + 1, high):
                        nodes.append(node(root, l_child, r_child))
            return nodes or [None]

        if n:
            return helper(1, n)
        else:
            return []


if __name__ == '__main__':
    cases = [
        (3, 5)
    ]
    for case in cases:
        res = len(Solution().generateTrees(case[0]))
        print(res == case[1], res)
