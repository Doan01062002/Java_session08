public class Bt04 {
    public static void main(String[] args) {
        String initialString = "abcdefghij".repeat(100000);

        // So sánh hiệu suất với StringBuilder
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder(initialString);
        sb.reverse();
        sb.insert(500000, "INSERTED_TEXT");
        sb.delete(400000, 400010);
        sb.replace(300000, 300010, "REPLACED_TEXT");
        long endTime = System.nanoTime();
        long durationStringBuilder = endTime - startTime;
        System.out.println("Thời gian thực thi StringBuilder: " + durationStringBuilder + " ns");

        // So sánh hiệu suất với StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer(initialString);
        sbf.reverse();
        sbf.insert(500000, "INSERTED_TEXT");
        sbf.delete(400000, 400010);
        sbf.replace(300000, 300010, "REPLACED_TEXT");
        endTime = System.nanoTime();
        long durationStringBuffer = endTime - startTime;
        System.out.println("Thời gian thực thi StringBuffer: " + durationStringBuffer + " ns");

        // So sánh kết quả
        if (durationStringBuilder < durationStringBuffer) {
            System.out.println("StringBuilder nhanh hơn.");
        } else {
            System.out.println("StringBuffer nhanh hơn.");
        }
    }
}
