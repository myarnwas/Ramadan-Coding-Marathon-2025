import java.util.*;

public class EnergyGridExperiment {
    static int r, c, n, p;
    static int[][] grid;
    static boolean[][] visited;
    static Set<Integer> uniqueEnergyLevels = new HashSet<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // قراءة المدخلات
        r = sc.nextInt();
        c = sc.nextInt();
        n = sc.nextInt();
        p = sc.nextInt();
        
        grid = new int[r][c];
        visited = new boolean[r][c];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        // معالجة انتقال الطاقة
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && grid[i][j] > 0 && grid[i][j] <= p) {
                    bfs(i, j);
                }
            }
        }
        
        // حساب النتيجة
        int y = uniqueEnergyLevels.size();
        int possibleLevels = n - 1;
        System.out.println(y + "/" + possibleLevels);
    }
    
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0], cy = current[1];
            int currentEnergy = grid[cx][cy];
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && nx < r && ny >= 0 && ny < c && grid[nx][ny] > 0) {
                    int newEnergy = grid[nx][ny] + (p - currentEnergy);
                    if (newEnergy >= 1 && newEnergy <= n) {
                        uniqueEnergyLevels.add(newEnergy);
                    }
                    
                    if (!visited[nx][ny] && grid[nx][ny] <= p) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
