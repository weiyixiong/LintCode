/**
 * Created by winney on 16/5/23.
 */
public class SegmentTreeBuild {
    /**
     * @param start, end: Denote an segment / interval
     * @return: The root of Segment Tree
     */
    public SegmentTreeNode build(int start, int end) {
        if (end < start) {
            return null;
        }
        if (start == end) {
            return buildChild(start, end);
        }
        SegmentTreeNode segmentTreeNode = new SegmentTreeNode(start, end);
        segmentTreeNode.left = build(start, (start + end) / 2);
        segmentTreeNode.right = build((start + end) / 2 + 1, end);
        return segmentTreeNode;
    }

    public SegmentTreeNode buildChild(int start, int end) {
        return new SegmentTreeNode(start, end);
    }
}
