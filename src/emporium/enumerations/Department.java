package emporium.enumerations;

public enum Department {
	
	A {
		@Override
		public String toString() {
			return "[F] Feed.";
		}
	},
	
	P {
		@Override
		public String toString() {
			return "[P] Plants.";
		}
	},
	
	F {
		@Override
		public String toString() {
			return "[M] Metalware.";
		}
	},
	
	S {
		@Override
		public String toString() {
			return "[S] Sport.";
		}
	},
	
	O {
		@Override
		public String toString() {
			return "[O] Other.";
		}
	};
	
}
