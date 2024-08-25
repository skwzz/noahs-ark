package song.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class BestAlbum {
    public static void main(String[] args) {
        BestAlbum p = new BestAlbum();
        int[] answer = p.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        display(answer); // [4, 1, 3, 0]
    }

    private static void display(int[] indexArr) {
        for (int index : indexArr) {
            System.out.print(index + " ");
        }
        System.out.println();
    }

    public int[] solution(String[] genres, int[] plays) {
        StreamingService service = new StreamingService();
        for (int i = 0; i < genres.length; i++) {
            service.play(new Song(i, genres[i], plays[i]));
        }
        return service.createBestAlbum();
    }

    private static class StreamingService{
        private final Map<String, Integer> genrePlayCountMap = new HashMap<>();
        private final Map<String, Queue<Song>> genreSongsMap = new HashMap<>();

        public void play(Song song){
            genrePlayCountMap.merge(song.genre, song.playCount, Integer::sum);
            genreSongsMap.computeIfAbsent(song.genre, genre -> new PriorityQueue<>()).add(song);
        }

        public int[] createBestAlbum() {
            List<String> genres = genrePlayCountMap.entrySet()
                    .stream()
                    .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
            List<Integer> bestAlbum = new ArrayList<>();
            for(String genre : genres){
                Queue<Song> songs = genreSongsMap.get(genre);
                int songCount = 0;
                while (!songs.isEmpty() && songCount < 2) {
                    bestAlbum.add(songs.poll().index);
                    songCount++;
                }
            }
            return bestAlbum.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
    }

    private static class Song implements Comparable<Song>{
        private final int index;
        private final String genre;
        private final int playCount;

        public Song(int index, String genre, int playCount) {
            this.index = index;
            this.genre = genre;
            this.playCount = playCount;
        }

        @Override
        public int compareTo(Song o) {
            if(this.playCount == o.playCount){
                return Integer.compare(this.index, o.index);
            }
            return Integer.compare(o.playCount, this.playCount);
        }
    }
}
/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (5.09ms, 69.5MB)
 * 테스트 2 〉	통과 (6.30ms, 76.3MB)
 * 테스트 3 〉	통과 (6.14ms, 70.9MB)
 * 테스트 4 〉	통과 (7.30ms, 79.4MB)
 * 테스트 5 〉	통과 (5.66ms, 74.3MB)
 * 테스트 6 〉	통과 (7.21ms, 82MB)
 * 테스트 7 〉	통과 (8.55ms, 81.7MB)
 * 테스트 8 〉	통과 (5.10ms, 77.4MB)
 * 테스트 9 〉	통과 (5.09ms, 74.7MB)
 * 테스트 10 〉	통과 (5.52ms, 73.3MB)
 * 테스트 11 〉	통과 (7.36ms, 83.6MB)
 * 테스트 12 〉	통과 (5.55ms, 75.9MB)
 * 테스트 13 〉	통과 (5.20ms, 87.6MB)
 * 테스트 14 〉	통과 (5.58ms, 74.9MB)
 * 테스트 15 〉	통과 (4.96ms, 78.2MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */