/**
 * Created by winney on 16/5/23.
 */
public class SegmentTreeBuild2 {
    /**
     * @param A: a list of integer
     * @return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        return build(0, A.length - 1, A);
    }

    public SegmentTreeNode buildChild(int start, int end, int max) {
        return new SegmentTreeNode(start, end, max);
    }

    /**
     * @param start, end: Denote an segment / interval
     * @return: The root of Segment Tree
     */
    public SegmentTreeNode build(int start, int end, int[] A) {
        if (end < start) {
            return null;
        }
        if (start == end) {
            return buildChild(start, end, A[start]);
        }

        SegmentTreeNode segmentTreeNode = new SegmentTreeNode(start, end);
        segmentTreeNode.left = build(start, (start + end) / 2, A);
        segmentTreeNode.right = build((start + end) / 2 + 1, end, A);
        segmentTreeNode.max = Math.max(segmentTreeNode.left.max, segmentTreeNode.right.max);
        return segmentTreeNode;
    }
}
