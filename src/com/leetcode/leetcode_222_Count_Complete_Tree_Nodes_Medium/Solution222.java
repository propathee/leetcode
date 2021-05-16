package com.leetcode.leetcode_222_Count_Complete_Tree_Nodes_Medium;

import com.leetcode.utils.TreeNode;

abstract class Solution222 {
    public abstract int countNodes(TreeNode root);

    static Solution222 newSolution() {
        return new S7();
    }

    private static class S1 extends Solution222 {
        @Override
        public int countNodes(TreeNode root) {
            int levels = countLevels(root);
            if (levels < 2) {
                return levels;
            }
            int idxL = 1, idxR = (int)Math.pow(2, levels - 2);
            int curLevel = 1;
            TreeNode nodeM = null;
            while (idxL < idxR) {
                nodeM = getMiddleNode(root, curLevel, levels - 1);
                if (nodeM.left == null) {
                    root = root.left;
                    idxR -= ((idxR - idxL + 1) / 2);
                } else {
                    root = root.right;
                    idxL += ((idxR - idxL + 1) / 2);
                }
                curLevel++;
            }
            nodeM = getMiddleNode(root, curLevel, levels - 1);
            int cnt = ((int)Math.pow(2, levels - 1) - 1);
            if (nodeM != null) {
                cnt += (idxL - 1) * 2;
                if (nodeM.left != null) {
                    cnt++;
                }
                if (nodeM.right != null) {
                    cnt++;
                }
            }
            return cnt;
        }

        private int countLevels(TreeNode root) {
            int levels = 0;
            while (root != null) {
                levels++;
                root = root.left;
            }
            return levels;
        }

        private TreeNode getMiddleNode(TreeNode root, int curLevel, int lastLevel) {
            if (curLevel >= lastLevel) {
                return root;
            }
            root = root.right;
            curLevel++;
            while (curLevel < lastLevel) {
                root = root.left;
                curLevel++;
            }
            return root;
        }
    }

    private static class S2 extends Solution222 {
        @Override
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int h = height(root);
            if (height(root.right) == h - 1) {
                return (1 << (h - 1)) + countNodes(root.right);
            } else {
                return (1 << (h - 2)) + countNodes(root.left);
            }
        }

        private int height(TreeNode root) {
            int height = 0;
            while (root != null) {
                height++;
                root = root.left;
            }
            return height;
        }
    }

    private static class S3 extends Solution222 {
        @Override
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int cnt = 0, height = height(root);
            while (root != null) {
                if (height(root.right) == height - 1) {
                    cnt += (1 << (height - 1));
                    root = root.right;
                } else {
                    cnt += (1 << (height - 2));
                    root = root.left;
                }
                height--;
            }
            return cnt;
        }

        private int height(TreeNode root) {
            int height = 0;
            while (root != null) {
                height++;
                root = root.left;
            }
            return height;
        }
    }

    private static class S4 extends Solution222 {
        @Override
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int heightL = 0, heightR = 0;
            TreeNode nodeL = root, nodeR = root;
            while (nodeL != null) {
                heightL++;
                nodeL = nodeL.left;
            }
            while (nodeR != null) {
                heightR++;
                nodeR = nodeR.right;
            }
            if (heightL == heightR) {
                return (1 << heightL) - 1;
            } else {
                return 1 + countNodes(root.left) + countNodes(root.right);
            }
        }
    }

    private static class S5 extends Solution222 {
        @Override
        public int countNodes(TreeNode root) {
            int height = height(root);
            if (height <= 1) {
                return height;
            }
            return (1 << (height - 1)) - 1 + countLastLevelNodes(root, height);
        }

        private int height(TreeNode root) {
            int height = 0;
            while (root != null) {
                height++;
                root = root.left;
            }
            return height;
        }

        private int countLastLevelNodes(TreeNode root, int height) {
            if (height == 1) {
                return root == null ? 0 : root.right == null ? 1 : 2;
            }
            TreeNode midNode = root.left;
            for (int curHeight = 1; curHeight < height - 1; curHeight++) {
                midNode = midNode.right;
            }
            if (midNode == null) {
                return countLastLevelNodes(root.left, height - 1);
            } else {
                return (1 << (height - 2)) + countLastLevelNodes(root.right, height - 1);
            }
        }
    }

    private static class S6 extends Solution222 {
        @Override
        public int countNodes(TreeNode root) {
            int height = height(root);
            if (height <= 1) {
                return height;
            }
            return (1 << (height - 1)) - 1 + countLastLevelNodes(root, height);
        }

        private int height(TreeNode root) {
            int height = 0;
            while (root != null) {
                height++;
                root = root.left;
            }
            return height;
        }

        private int countLastLevelNodes(TreeNode root, int height) {
            if (height == 1) {
                return root == null ? 0 : root.right == null ? 1 : 2;
            }
            TreeNode midNode = root.right;
            for (int curHeight = 1; curHeight < height - 1; curHeight++) {
                midNode = midNode.left;
            }
            if (midNode == null) {
                return countLastLevelNodes(root.left, height - 1);
            } else {
                return (1 << (height - 2)) + countLastLevelNodes(root.right, height - 1);
            }
        }
    }

    private static class S7 extends Solution222 {
        @Override
        public int countNodes(TreeNode root) {
            int height = height(root);
            if (height <= 1) {
                return height;
            }
            return (1 << (height - 1)) - 1 + countLastLevelNodes(root, height);
        }

        private int height(TreeNode root) {
            int height = 0;
            while (root != null) {
                height++;
                root = root.left;
            }
            return height;
        }

        private int countLastLevelNodes(TreeNode root, int height) {
            int cnt = 0;
            TreeNode midNode;
            while (height > 1) {
                midNode = getMidNodeOfLastLevel(root, height);
                if (midNode == null) {
                    root = root.left;
                } else {
                    root = root.right;
                    cnt += ((1 << (height - 2)));
                }
                height--;
            }
            cnt += (root == null ? 0 : root.right == null ? 1 : 2);
            return cnt;
        }

        private TreeNode getMidNodeOfLastLevel(TreeNode root, int height) {
            root = root.right;
            for (int curHeight = 2; curHeight < height; curHeight++) {
                root = root.left;
            }
            return root;
        }
    }
}
