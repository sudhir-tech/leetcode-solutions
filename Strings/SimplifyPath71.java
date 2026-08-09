class Solution {
    public String simplifyPath(String path) { 
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String component : components) {
            if (component.equals("") || component.equals(".")) {
                continue; // Skip empty and current directory components
            } else if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Go up one directory
                }
            } else {
                stack.push(component); // Valid directory name, push to stack
            }
        }

        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }

        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
        
    }
}